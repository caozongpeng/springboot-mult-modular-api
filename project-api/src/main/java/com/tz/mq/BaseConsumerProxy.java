package com.tz.mq;

import com.rabbitmq.client.Channel;
import com.tz.core.constants.Constants;
import com.tz.dao.log.model.TMsgLog;
import com.tz.service.log.MsgLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 消息者代理类
 * @author KyrieCao
 * @date 2020/2/13 22:35
 */
@Slf4j
public class BaseConsumerProxy {

    private Object target;

    private MsgLogService msgLogService;

    public BaseConsumerProxy(Object target, MsgLogService msgLogService) {
        this.target = target;
        this.msgLogService = msgLogService;
    }

    /**
     * 获取代理
     * @return Object
     * @author KyrieCao
     * @date 2020/2/13 22:39
     */
    public Object getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, (proxy1, method, args) -> {
            Message message = (Message) args[0];
            Channel channel = (Channel) args[1];

            String correlationId = getCorrelationId(message);

            // 消费幂等性, 防止消息被重复消费
            if (isConsumed(correlationId)) {
                log.info("重复消费, correlationId: {}", correlationId);
                return null;
            }

            MessageProperties properties = message.getMessageProperties();
            long tag = properties.getDeliveryTag();

            try {
                Object result = method.invoke(target, args);//真正消费的业务逻辑
                msgLogService.updateStatusByMsgId(correlationId, Constants.MsgLogStatus.CONSUMED_SUCCESS);
                channel.basicAck(tag, false); // 消费确认
                return result;
            } catch (Exception e) {
                log.error("getProxy error", e);
                channel.basicNack(tag, false, true);
                return null;
            }
        });
        return proxy;
    }

    /**
     * 获取 getCorrelationId
     * @param message           消息
     * @return String
     * @author KyrieCao
     * @date 2020/2/13 22:51
     */
    private String getCorrelationId(Message message) {
        String correlation = null;

        MessageProperties properties = message.getMessageProperties();
        Map<String, Object> headers = properties.getHeaders();
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            if (key.equals("spring_returned_message_correlation")) {
                correlation = value;
            }
        }
        return correlation;
    }

    /**
     * 消息是否已被消费
     * @param correlationId         消息id
     * @return boolean
     * @author KyrieCao
     * @date 2020/2/13 22:54
     */
    private boolean isConsumed(String correlationId) {
        TMsgLog msgLog = msgLogService.findByMsgId(correlationId);
        if (null == msgLog || msgLog.getStatus().equals(Constants.MsgLogStatus.CONSUMED_SUCCESS)) {
            return true;
        }
        return false;
    }

}
