package com.tz.api.user;

import com.tz.api.BaseController;
import com.tz.core.exception.BusinessException;
import com.tz.core.model.ApiResponse;
import com.tz.core.model.Page;
import com.tz.dao.user.model.TUser;
import com.tz.dao.user.req.UserReq;
import com.tz.dao.user.req.UserSaveReq;
import com.tz.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * @author KyrieCao
 * @date 2020/2/4 14:53
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户分页列表
     * @param req       请求对象
     * @return ApiResponse<Page<TUser>>
     * @author KyrieCao
     * @date 2020/2/4 16:56
     */
    @ApiOperation("用户分页列表")
    @PostMapping("/list")
    public ApiResponse<Page<TUser>> findPage(@RequestBody UserReq req) {
        Page<TUser> users = userService.findPage(req);
        return new ApiResponse<Page<TUser>>().success(users);
    }

    /**
     * 根据ID查询用户
     * @param id        用户id
     * @return ApiResponse<TUser>
     * @author KyrieCao
     * @date 2020/2/4 15:25
     */
    @ApiOperation("查询单个用户")
    @GetMapping("/{id}")
    public ApiResponse<TUser> findById(@PathVariable Integer id) {
        TUser user = userService.findById(id);
        return new ApiResponse<TUser>().success(user);
    }

    /**
     * 创建用户
     * @param req       用户请求对象
     * @return ApiResponse<TUser>
     * @author KyrieCao
     * @date 2020/2/4 15:56
     */
    @ApiOperation("创建用户")
    @PostMapping("/create")
    public ApiResponse<TUser> create(@RequestBody UserSaveReq req) {
        TUser user = userService.create(req);
        return new ApiResponse<TUser>().success(user);
    }

    /**
     * 根据ID删除用户
     * @param id        用户id
     * @return ApiResponse<?>
     * @author KyrieCao
     * @date 2020/2/4 16:11
     */
    @ApiOperation("删除单个用户")
    @GetMapping("/delete/{id}")
    public ApiResponse<?> deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return new ApiResponse<>().success();
    }

    /**
     * 根据ID更新用户
     * @param req           请求对象
     * @return ApiResponse<?>
     * @author KyrieCao
     * @date 2020/2/4 16:18
     */
    @ApiOperation("更新用户")
    @PostMapping("/update")
    public ApiResponse<?> updateById(@RequestBody UserSaveReq req) {
        userService.updateById(req);
        return new ApiResponse<>().success();
    }
}
