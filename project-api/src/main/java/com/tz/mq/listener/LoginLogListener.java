package com.tz.mq.listener;

import com.rabbitmq.client.Channel;
import com.tz.core.constants.Constants;
import com.tz.core.mq.BaseConsumer;
import com.tz.mq.BaseConsumerProxy;
import com.tz.mq.consumer.LoginLogConsumer;
import com.tz.service.log.MsgLogService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户日志监听器
 * @author KyrieCao
 * @date 2020/2/16 22:17
 */
@Component
public class LoginLogListener {

    @Autowired
    private LoginLogConsumer loginLogConsumer;

    @Autowired
    private MsgLogService msgLogService;

    /**
     * 消费监听方法
     * @param message       消息
     * @param channel       通道
     * @author KyrieCao
     * @date 2020/2/16 22:20
     */
    @RabbitListener(queues = Constants.RabbitMqConstants.LOGIN_LOG_QUEUE_NAME)
    public void consume(Message message, Channel channel) {
        BaseConsumerProxy baseConsumerProxy = new BaseConsumerProxy(loginLogConsumer, msgLogService);
        BaseConsumer proxy = (BaseConsumer) baseConsumerProxy.getProxy();
        if (null != proxy) {
            proxy.consume(message, channel);
        }
    }
}
