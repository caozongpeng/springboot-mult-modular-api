package com.tz.core.model;

import com.tz.core.constants.Constants;
import com.tz.core.exception.BusinessException;
import com.tz.core.utils.Generator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * 前端接口请求响应对象
 * @author KyrieCao
 * @date 2020/2/3 22:27
 */
@Data
@Slf4j
public class ApiResponse<T> {

    // 响应码
    private String code;

    // 响应消息
    private String message;

    // 响应数据
    private T data;

    // 异常id
    private String eid;

    // 响应错误数据
    private Object edata;

    public ApiResponse(){}

    /**
     * 成功
     * - 请求成功，传入返回数据
     * @param data
     */
    public ApiResponse<T> success(T data){
        this.set("", Constants.Status.SUCCESS.getCode(), Constants.Status.SUCCESS.getMessage(), data, null);
        return this;
    }

    /**
     * 成功
     * - 请求成功
     */
    public ApiResponse<T> success(){
        this.set("", Constants.Status.SUCCESS.getCode(), Constants.Status.SUCCESS.getMessage(), null, null);
        return this;
    }

    /**
     * 系统异常
     */
    public ApiResponse<T> error(){
        this.set(Generator.genExceptionId(), Constants.Status.ERROR.getCode(), Constants.Status.ERROR.getMessage(), null, null);
        return this;
    }

    /**
     * 业务异常
     * @param status 失败状态对象
     */
    public ApiResponse<T> failed(ResponseStatus status){
        this.set(null, status.getCode(), status.getMessage(), null, null);
        return this;
    }

    /**
     * 业务异常
     * @param status 失败状态对象
     * @param errorData 异常数据
     */
    public ApiResponse<T> failed(ResponseStatus status, Object errorData){
        this.set(null, status.getCode(), status.getMessage(), null, errorData);
        return this;
    }

    /**
     * 业务异常
     * @param message 错误消息
     */
    public ApiResponse<T> failed(String message){
        this.set(null, Constants.Status.FAILED.getCode(), message, null, null);
        return this;
    }

    /**
     * 业务异常
     * @param e 业务异常对象
     * @return
     */
    public ApiResponse<T> failed(BusinessException e){
        log.error(e.getMessage(), e);
        this.set(e.getEid(), e.getCode(), e.getMessage(), null, e.getEdata());
        return this;
    }

    /**
     * 未登录
     */
    public ApiResponse<T> nologin(){
        this.set(null, Constants.Status.USER_EXPIRES.getCode(), Constants.Status.USER_EXPIRES.getMessage(), null, null);
        return this;
    }

    private void set(String eid, String code, String message, T data, Object errData){
        this.eid = eid == null ? Generator.genExceptionId() : ("".equals(eid) ? null : eid);
        this.code = code;
        this.message = message;
        this.data = data;
        this.edata = errData;
    }
}
