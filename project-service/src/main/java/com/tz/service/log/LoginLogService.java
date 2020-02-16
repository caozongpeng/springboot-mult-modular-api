package com.tz.service.log;

import com.tz.dao.log.model.TLoginLog;

/**
 * 登录日志接口
 * @author KyrieCao
 * @date 2020/2/16 22:08
 */
public interface LoginLogService {

    /**
     * 创建
     * @param loginLog      用户日志
     * @author KyrieCao
     * @date 2020/2/16 22:09
     */
    void create(TLoginLog loginLog);
}
