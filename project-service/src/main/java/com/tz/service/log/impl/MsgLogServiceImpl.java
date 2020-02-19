package com.tz.service.log.impl;

import com.tz.core.constants.Constants;
import com.tz.core.exception.BusinessException;
import com.tz.core.utils.JodaTimeUtil;
import com.tz.dao.log.TMsgLogMapper;
import com.tz.dao.log.model.TMsgLog;
import com.tz.dao.log.model.TMsgLogExample;
import com.tz.service.log.MsgLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public void updateTryCountByMsgIdAndTryTime(String msgId, Date tryTime) {
        TMsgLog msgLog = findByMsgId(msgId);
        if (null == msgLog) throw new BusinessException(Constants.Status.DATA_EMPTY);

        Date nextTryTime = JodaTimeUtil.plusMinutes(tryTime, 1);

        msgLog.setTryCount(msgLog.getTryCount() + 1);
        msgLog.setNextTryTime(nextTryTime);
        msgLog.setUpdateTime(new Date());

        msgLogMapper.updateByPrimaryKeySelective(msgLog);
    }

    @Override
    public List<TMsgLog> selectTimeoutMsg() {
        return msgLogMapper.selectTimeoutMsg();
    }

    @Override
    public void updateStatusByMsgId(String msgId, Integer status) {
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
