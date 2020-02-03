package com.tz.core.exception;

import com.tz.core.constants.Constants;
import com.tz.core.model.ResponseStatus;
import com.tz.core.utils.Generator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 业务异常
 * - Service抛出，Controller捕获
 * @author KyrieCao
 * @date 2020/2/3 22:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class BusinessException extends RuntimeException {
    // 异常id
    private String eid;

    // 错误码
    private String code;

    // 错误消息
    private String message;

    // 错误数据
    private Object edata;

    private BusinessException(String exceptionId, String code, String message, Object errData, Throwable e){
        super(e);
        this.eid = exceptionId;
        this.code = code;
        this.message = message;
        this.edata = errData;
    }

    public BusinessException(String message){
        this(Generator.genExceptionId(), Constants.Status.FAILED.getCode(), message, null, null);
    }

    public BusinessException(String message, Throwable e){
        this(Generator.genExceptionId(), Constants.Status.FAILED.getCode(), message, null, e);
    }

    public BusinessException(String message, Object errData){
        this(Generator.genExceptionId(), Constants.Status.FAILED.getCode(), message, errData, null);
    }

    public BusinessException(ResponseStatus status){
        this(Generator.genExceptionId(), status.getCode(), status.getMessage(), null, null);
    }

    public BusinessException(ResponseStatus status, Object errData){
        this(Generator.genExceptionId(), status.getCode(), status.getMessage(), errData, null);
    }

    public BusinessException(ResponseStatus status, Throwable e){
        this(Generator.genExceptionId(), status.getCode(), status.getMessage(), null, e);
    }

    public void print(){
        log.error(this.getEid() + ": " + this.getCode() + "-" + this.getMessage(), this);
    }
}
