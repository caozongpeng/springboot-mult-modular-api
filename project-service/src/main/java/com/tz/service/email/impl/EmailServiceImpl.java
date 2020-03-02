package com.tz.service.email.impl;

import com.alibaba.fastjson.JSONObject;
import com.tz.core.constants.Constants;
import com.tz.core.model.Mail;
import com.tz.core.mq.MessageHelper;
import com.tz.core.utils.JodaTimeUtil;
import com.tz.core.utils.RandomUtil;
import com.tz.dao.log.TMsgLogMapper;
import com.tz.dao.log.model.TMsgLog;
import com.tz.service.email.EmailService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * email service实现
 * @author KyrieCao
 * @date 2020/2/11 22:01
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private TMsgLogMapper msgLogMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendEmail(Mail mail) {
        String msgId = RandomUtil.UUID32();
        mail.setMsgId(msgId);

        Date now = new Date();

        // 消息日志
        TMsgLog msgLog = new TMsgLog();
        msgLog.setMsgId(msgId);
        msgLog.setMsg(JSONObject.toJSONString(mail));
        msgLog.setExchange(Constants.RabbitMqConstants.MAIL_EXCHANGE_NAME);
        msgLog.setRoutingKey(Constants.RabbitMqConstants.MAIL_ROUTING_KEY_NAME);
        msgLog.setStatus(Constants.MsgLogStatus.DELIVERING);
        msgLog.setTryCount(0);
        msgLog.setCreateTime(now);
        msgLog.setUpdateTime(now);
        msgLog.setNextTryTime(JodaTimeUtil.plusMinutes(now,1));

        // 消息入库
        msgLogMapper.insert(msgLog);

        CorrelationData correlationData = new CorrelationData(msgId);
        // 发送消息
        rabbitTemplate.convertAndSend(Constants.RabbitMqConstants.MAIL_EXCHANGE_NAME, Constants.RabbitMqConstants.MAIL_ROUTING_KEY_NAME, MessageHelper.objToMsg(mail), correlationData);
    }
}
