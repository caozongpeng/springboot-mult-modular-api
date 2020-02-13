package com.tz.mq.consumer;

import com.rabbitmq.client.Channel;
import com.tz.core.exception.BusinessException;
import com.tz.core.model.Mail;
import com.tz.core.mq.BaseConsumer;
import com.tz.core.mq.MessageHelper;
import com.tz.core.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 邮件消息者
 * @author KyrieCao
 * @date 2020/2/13 23:13
 */
@Component
@Slf4j
public class MailConsumer implements BaseConsumer {

    @Autowired
    private MailUtil mailUtil;

    @Override
    public void consume(Message message, Channel channel) {
        Mail mail = MessageHelper.msgToObj(message, Mail.class);
        log.info("收到消息: {}", mail.toString());

        boolean success = mailUtil.send(mail);
        if (!success) {
            throw new BusinessException("send mail error");
        }
    }
}
