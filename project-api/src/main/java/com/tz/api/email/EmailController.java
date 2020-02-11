package com.tz.api.email;

import com.tz.api.BaseController;
import com.tz.core.exception.BusinessException;
import com.tz.core.model.ApiResponse;
import com.tz.core.model.Mail;
import com.tz.service.email.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
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
     * @param mail          email对象
     * @param errors        错误消息
     * @return ApiResponse<?>
     * @author KyrieCao
     * @date 2020/2/11 22:24
     */
    @ApiOperation("发送邮件")
    @PostMapping("/sendEmail")
    public ApiResponse<?> sendEmail(@Validated Mail mail, Errors errors) {
        try {
            if (errors.hasErrors()) {
                String msg = errors.getFieldError().getDefaultMessage();
                return new ApiResponse<>().failed(msg);
            }
            emailService.sendEmail(mail);
        } catch (BusinessException e) {
            return new ApiResponse<>().failed(e);
        }
        return new ApiResponse<>().success();
    }
}
