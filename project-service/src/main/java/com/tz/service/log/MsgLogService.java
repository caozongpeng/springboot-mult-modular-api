package com.tz.service.log;

import com.tz.core.exception.BusinessException;
import com.tz.dao.log.model.TMsgLog;

/**
 * 消息日志 service 接口
 * @author KyrieCao
 * @date 2020/2/10 22:01
 */
public interface MsgLogService {


    /**
     *  通过消息id更新状态
     * @param msgId         消息id
     * @param status        状态
     * @author KyrieCao
     * @date 2020/2/10 22:12
     */
    void updateStatusByMsgId(String msgId, Integer status);

    /**
     * 消息 id 查询消息
     * @param msgId     消息id
     * @return TMsgLog
     * @author KyrieCao
     * @date 2020/2/10 22:07
     */
    TMsgLog findByMsgId(String msgId);

}
