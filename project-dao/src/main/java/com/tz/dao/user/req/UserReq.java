package com.tz.dao.user.req;

import com.tz.core.model.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询请求参数
 * @author KyrieCao
 * @date 2020/2/4 15:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("用户查询请求参数")
public class UserReq extends PageQuery {
    @ApiModelProperty(value = "主键id", hidden = true)
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty(value = "密码", hidden = true)
    private String password;
}
