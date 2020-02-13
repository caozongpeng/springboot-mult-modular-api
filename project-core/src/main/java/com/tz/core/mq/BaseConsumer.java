package com.tz.core.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

/**
 * 消息者接口
 * @author KyrieCao
 * @date 2020/2/13 22:32
 */
public interface BaseConsumer {

    /**
     * 消费者方法
     * @param message       消息
     * @param channel       通道号
     * @author KyrieCao
     * @date 2020/2/13 22:34
     */
    void consume(Message message, Channel channel);
}
