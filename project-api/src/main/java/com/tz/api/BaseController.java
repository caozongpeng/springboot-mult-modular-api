package com.tz.api;

import com.tz.core.exception.BusinessException;
import com.tz.core.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Basic Controller
 * @author KyrieCao
 * @date 2020/2/4 14:41
 */
@Slf4j
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    /**
     * Inject HttpServletRequest and HttpServletResponse
     * @param request       请求对象
     * @param response      响应对象
     * @author KyrieCao
     * @date 2020/2/4 14:44
     */
    @ModelAttribute
    protected void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }


    /**
     * The Global exception handler
     * @param e         异常对象
     * @return ApiResponse<?>
     * @author KyrieCao
     * @date 2020/2/4 14:46
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> exceptionHandler(Exception e) {
        if (e instanceof BusinessException) {
            ApiResponse<?> response = new ApiResponse<>().failed((BusinessException) e);
            log.error(response.getEid() + ":" + e.getMessage(), e);
            return new ApiResponse<>().failed((BusinessException) e);
        }
        ApiResponse<?> response = new ApiResponse<>().error();
        log.error(response.getEid() + ":" + e.getMessage(), e);
        return response;
    }

}
