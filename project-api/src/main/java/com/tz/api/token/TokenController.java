package com.tz.api.token;

import com.tz.api.BaseController;
import com.tz.core.model.ApiResponse;
import com.tz.service.token.TokenService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * token 接口
 * @author KyrieCao
 * @date 2020/2/5 23:15
 */
@Api(tags = "token接口")
@RestController
@RequestMapping("/token")
public class TokenController extends BaseController {

    @Autowired
    private TokenService tokenService;

    /**
     * 创建 token
     * @return ApiResponse<String>
     * @author KyrieCao
     * @date 2020/2/5 23:18
     */
    @GetMapping("/create")
    public ApiResponse<String> createToken() {
        String token = tokenService.createToken();
        return new ApiResponse<String>().success(token);
    }


}
