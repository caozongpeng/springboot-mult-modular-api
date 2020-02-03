package com.tz.core.model;

/**
 * 响应状态，所有响应状态均需要实现该接口
 * @author KyrieCao
 * @date 2020/2/3 22:19
 */
public interface ResponseStatus {
    /**
     * 获取状态码
     */
    String getCode();

    /**
     * 获取状态消息
     */
    String getMessage();
}
