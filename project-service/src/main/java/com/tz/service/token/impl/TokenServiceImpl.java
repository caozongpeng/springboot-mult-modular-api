package com.tz.service.token.impl;

import com.tz.core.constants.Constants;
import com.tz.core.utils.JedisUtil;
import com.tz.core.utils.RandomUtil;
import com.tz.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * token 业务层接口实现
 * @author KyrieCao
 * @date 2020/2/5 22:52
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public String createToken() {
        String uuid = RandomUtil.UUID32();
        StringBuilder token = new StringBuilder();
        token.append(Constants.Redis.TOKEN_PREFIX).append(uuid);
        // 存入redis
        jedisUtil.set(token.toString(), token.toString(), Constants.Redis.EXPIRE_TIME_MINUTE);
        // 返回token
        return token.toString();
    }

    @Override
    public void checkToken(HttpServletRequest request) {

    }

}
