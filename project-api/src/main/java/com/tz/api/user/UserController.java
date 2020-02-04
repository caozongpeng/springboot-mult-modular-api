package com.tz.api.user;

import com.tz.api.BaseController;
import com.tz.core.exception.BusinessException;
import com.tz.core.model.ApiResponse;
import com.tz.dao.user.model.TUser;
import com.tz.dao.user.req.UserReq;
import com.tz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * @author KyrieCao
 * @date 2020/2/4 14:53
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param id        用户id
     * @return ApiResponse<TUser>
     * @author KyrieCao
     * @date 2020/2/4 15:25
     */
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
    @PostMapping("/create")
    public ApiResponse<TUser> create(@RequestBody UserReq req) {
        try {
            TUser user = userService.create(req);
            return new ApiResponse<TUser>().success(user);
        } catch (BusinessException e) {
            return new ApiResponse<TUser>().failed(e);
        }
    }

    /**
     * 根据ID删除用户
     * @param id        用户id
     * @return ApiResponse<?>
     * @author KyrieCao
     * @date 2020/2/4 16:11
     */
    @GetMapping("/delete/{id}")
    public ApiResponse<?> deleteById(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
            return new ApiResponse<>().success();
        } catch (BusinessException e) {
            return new ApiResponse<>().failed(e);
        }
    }

    /**
     * 根据ID更新用户
     * @param req           请求对象
     * @return ApiResponse<?>
     * @author KyrieCao
     * @date 2020/2/4 16:18
     */
    @PostMapping("/update")
    public ApiResponse<?> updateById(@RequestBody UserReq req) {
        try {
            userService.updateById(req);
            return new ApiResponse<>().success();
        } catch (BusinessException e) {
            return new ApiResponse<>().failed(e);
        }
    }
}
