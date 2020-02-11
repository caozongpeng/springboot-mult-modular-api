package com.tz.service.log.impl;

import com.tz.core.constants.Constants;
import com.tz.core.exception.BusinessException;
import com.tz.dao.log.TMsgLogMapper;
import com.tz.dao.log.model.TMsgLog;
import com.tz.service.log.MsgLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 消息日志 service 接口实现
 * @author KyrieCao
 * @date 2020/2/10 22:02
 */
@Service("msgLogService")
public class MsgLogServiceImpl implements MsgLogService {

    @Autowired
    private TMsgLogMapper msgLogMapper;

    @Override
    public void updateStatusByMsgId(String msgId, Integer status) throws BusinessException {
        TMsgLog msgLog = findByMsgId(msgId);
        if (null == msgLog) throw new BusinessException(Constants.Status.DATA_EMPTY);
        msgLog.setStatus(status);
        msgLog.setUpdateTime(new Date());
        int resultNum = msgLogMapper.updateByPrimaryKeySelective(msgLog);
        if (resultNum == 0) throw new BusinessException(Constants.Status.UPDATE_FAILURE);
    }

    @Override
    public TMsgLog findByMsgId(String msgId) {
        return msgLogMapper.selectByPrimaryKey(msgId);
    }
}
