package com.tz.service.email;

import com.tz.core.model.Mail;

/**
 * email service 接口
 * @author KyrieCao
 * @date 2020/2/11 22:01
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param mail      mail对象
     * @author KyrieCao
     * @date 2020/2/11 22:03
     */
    void sendEmail(Mail mail);

}
