package com.tz.config;

import com.tz.core.constants.Constants;
import com.tz.service.log.MsgLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq配置类
 * @author KyrieCao
 * @date 2020/2/10 20:03
 */
@Configuration
@Slf4j
public class RabbitConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private MsgLogService msgLogService;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());

        // 消息是否成功发送到 Exchange
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("消息成功发送到Exchange");
                String msgId = correlationData.getId();
                msgLogService.updateStatusByMsgId(msgId, Constants.MsgLogStatus.DELIVER_SUCCESS);
            } else {
                log.info("消息发送到Exchange失败, {}, cause: {}", correlationData, cause);
            }
        });

        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("消息从Exchange路由到Queue失败: exchange: {}, route: {}, replyCode: {}, replyText: {}, message: {}", exchange, routingKey, replyCode, replyText, message);
        });

        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public Queue logUserQueue() {
        return new Queue(Constants.RabbitMqConstants.LOGIN_LOG_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange logUserExchange() {
        return new DirectExchange(Constants.RabbitMqConstants.LOGIN_LOG_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding logUserBinding() {
        return BindingBuilder.bind(logUserQueue()).to(logUserExchange()).with(Constants.RabbitMqConstants.LOGIN_LOG_ROUTING_KEY_NAME);
    }

    @Bean
    public Queue mailQueue() {
        return new Queue(Constants.RabbitMqConstants.MAIL_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange mailExchange() {
        return new DirectExchange(Constants.RabbitMqConstants.MAIL_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding mailBinding() {
        return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(Constants.RabbitMqConstants.MAIL_ROUTING_KEY_NAME);
    }

}
