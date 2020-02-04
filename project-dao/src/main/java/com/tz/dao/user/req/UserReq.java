package com.tz.dao.user.req;

import lombok.Data;

/**
 * 创建用户请求对象
 * @author KyrieCao
 * @date 2020/2/4 15:47
 */
@Data
public class UserReq {
    private Integer id;
    private String username;
    private String password;
}
