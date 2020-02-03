package com.tz.core.constants;

import com.tz.core.model.ResponseStatus;
import lombok.AllArgsConstructor;

/**
 * 系统常量
 * @author KyrieCao
 * @date 2020/2/3 22:15
 */
public class Constants {

    /**
     * 系统通用响应状态
     * @author Caesar Liu
     * @date 2018/7/17
     */
    @AllArgsConstructor
    public enum Status implements ResponseStatus {
        SUCCESS("000000","请求成功"),
        FAILURE("000001","请求失败"),
        USER_EXPIRES("000002", "您未登录或登录信息已过期"),
        PARAM_EMPTY("000003", "缺少请求参数"),
        DATA_EMPTY("000004", "未找到目标资源"),
        GEN_EXISTS_UNUSABLE_TPL("000100", "存在不可用的模版"),
        DATA_ERROR("999996", "数据异常"),
        BAD_REQUEST("999997", "非法请求"),
        FAILED("999998", "业务异常"),
        ERROR("999999","系统繁忙，请稍后再试"),
        ID_EMPTY("000020","缺少数据ID"),
        USER_EMPTY("000021","缺少用户ID"),
        CREATE_FAILURE("000030", "新增失败"),
        UPDATE_FAILURE("000031", "更新失败"),
        DELETE_FAILURE("000032", "删除失败"),
        SHARE_TOKEN_ILLEGAL("000042", "分享已过期"),
        SHARE_TOKEN_EXPIRED("000043", "分享已过期"),
        SHARE_TOKEN_NOPWD("000044", "缺少令牌密码"),
        SHARE_TOKEN_PWD_FAULT("000045", "令牌密码错误"),
        ;

        private String code;

        private String message;

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
