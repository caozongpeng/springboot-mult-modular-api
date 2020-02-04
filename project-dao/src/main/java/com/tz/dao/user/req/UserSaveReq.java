package com.tz.dao.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户保存请求对象
 * @author KyrieCao
 * @date 2020/2/4 20:27
 */
@Data
@ApiModel("用户保存请求参数")
public class UserSaveReq{
    @ApiModelProperty("主键id")
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}
