package com.tz.dao.user.req;

import com.tz.core.model.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建用户请求对象
 * @author KyrieCao
 * @date 2020/2/4 15:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserReq extends PageQuery {
    private Integer id;
    private String username;
    private String password;
}
