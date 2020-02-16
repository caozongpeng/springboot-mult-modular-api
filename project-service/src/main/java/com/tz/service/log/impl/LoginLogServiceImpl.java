package com.tz.service.log.impl;

import com.tz.dao.log.TLoginLogMapper;
import com.tz.dao.log.model.TLoginLog;
import com.tz.service.log.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户日志接口实现
 * @author KyrieCao
 * @date 2020/2/16 22:10
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private TLoginLogMapper loginLogMapper;

    @Override
    public void create(TLoginLog loginLog) {
        loginLogMapper.insert(loginLog);
    }
}
