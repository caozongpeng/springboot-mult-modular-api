package com.tz.mq.consumer;

import com.rabbitmq.client.Channel;
import com.tz.core.mq.BaseConsumer;
import com.tz.core.mq.MessageHelper;
import com.tz.dao.log.model.TLoginLog;
import com.tz.service.log.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录日志消费者
 * @author KyrieCao
 * @date 2020/2/16 22:06
 */
@Component
@Slf4j
public class LoginLogConsumer implements BaseConsumer {

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public void consume(Message message, Channel channel) {
        log.info("收到消息：{}", message.toString());
        TLoginLog loginLog = MessageHelper.msgToObj(message, TLoginLog.class);
        loginLogService.create(loginLog);
    }
}
