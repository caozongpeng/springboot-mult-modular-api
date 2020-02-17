package com.tz.api.email;

import com.tz.api.BaseController;
import com.tz.core.annotation.ApiIdempotent;
import com.tz.core.model.ApiResponse;
import com.tz.core.model.Mail;
import com.tz.service.email.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送邮件接口
 * @author KyrieCao
 * @date 2020/2/11 21:59
 */
@RestController
@RequestMapping("/email")
@Api(tags = "发送邮件接口")
public class EmailController extends BaseController {

    @Autowired
    private EmailService emailService;

    /**
     * 发送邮件
     * -- 加了 @ApiIdempotent 注解 需要先获取token复制token拼接到 /email/sendEmail?token=token 才可以
     * @param mail          email对象
     * @param errors        错误消息
     * @return ApiResponse<?>
     * @author KyrieCao
     * @date 2020/2/11 22:24
     */
    @ApiIdempotent
    @ApiOperation("发送邮件")
    @PostMapping("/sendEmail")
    public ApiResponse<?> sendEmail(@Validated Mail mail, Errors errors) {
        if (errors.hasErrors()) {
            FieldError fieldError = errors.getFieldError();
            if (fieldError != null)
                return new ApiResponse<>().failed(fieldError.getDefaultMessage());
        }
        emailService.sendEmail(mail);
        return new ApiResponse<>().success();
    }
}
