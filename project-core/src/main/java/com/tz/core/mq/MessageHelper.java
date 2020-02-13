package com.tz.core.mq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;

/**
 * 消息帮助
 * @author KyrieCao
 * @date 2020/2/13 22:29
 */
public class MessageHelper {

    /**
     * 对象转消息类型
     * @param obj       任何对象
     * @return Message
     * @author KyrieCao
     * @date 2020/2/13 22:30
     */
    public static Message objToMsg(Object obj) {
        if (null == obj) {
            return null;
        }

        Message message = MessageBuilder.withBody(JSONObject.toJSONString(obj).getBytes()).build();
        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);// 消息持久化
        message.getMessageProperties().setContentType(MessageProperties.CONTENT_TYPE_JSON);

        return message;
    }


    /**
     * 消息类型转对象
     * @param message       消息
     * @param clazz         对象类
     * @return T
     * @author KyrieCao
     * @date 2020/2/13 22:31
     */
    public static <T> T msgToObj(Message message, Class<T> clazz) {
        if (null == message || null == clazz) {
            return null;
        }

        String str = new String(message.getBody());
        T obj = JSONObject.parseObject(str, clazz);

        return obj;
    }
}
