package com.tz.service.token;

import javax.servlet.http.HttpServletRequest;

/**
 * token业务层接口
 * @author KyrieCao
 * @date 2020/2/5 22:52
 */
public interface TokenService {

    /**
     * 创建 token 并存入redis
     * @return String
     * @author KyrieCao
     * @date 2020/2/5 22:55
     */
    String createToken();

    /**
     * token验证
     * @param request       请求对象
     * @author KyrieCao
     * @date 2020/2/5 22:55
     */
    void checkToken(HttpServletRequest request);
}
