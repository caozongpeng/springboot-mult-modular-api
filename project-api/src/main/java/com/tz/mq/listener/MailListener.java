package com.tz.mq.listener;

import com.rabbitmq.client.Channel;
import com.tz.config.RabbitConfig;
import com.tz.core.constants.Constants;
import com.tz.core.mq.BaseConsumer;
import com.tz.mq.BaseConsumerProxy;
import com.tz.mq.consumer.MailConsumer;
import com.tz.service.log.MsgLogService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 邮件监听器
 * @author KyrieCao
 * @date 2020/2/13 23:05
 */
@Component
public class MailListener {

    @Autowired
    private MailConsumer mailConsumer;

    @Autowired
    private MsgLogService msgLogService;

    /**
     * 消费方法
     * @param message       消息
     * @param channel       通道
     * @author KyrieCao
     * @date 2020/2/13 23:19
     */
    @RabbitListener(queues = Constants.RabbitMqConstants.MAIL_QUEUE_NAME)
    public void consume(Message message, Channel channel) {
        BaseConsumerProxy baseConsumerProxy = new BaseConsumerProxy(mailConsumer, msgLogService);
        BaseConsumer proxy = (BaseConsumer) baseConsumerProxy.getProxy();
        if (null != proxy) {
            proxy.consume(message, channel);
        }
    }
}
