package com.tz.service.log;

import com.tz.dao.log.model.TMsgLog;

import java.util.Date;
import java.util.List;

/**
 * 消息日志 service 接口
 * @author KyrieCao
 * @date 2020/2/10 22:01
 */
public interface MsgLogService {

    /**
     * 通过消息id和时间更新tryCont
     * @param msgId         消息id
     * @param tryTime       时间
     * @author KyrieCao
     * @date 2020/2/18 22:21
     */
    void updateTryCountByMsgIdAndTryTime(String msgId, Date tryTime);

    /**
     * 查询发送失败消息
     * @return List<TMsgLog>
     * @author KyrieCao
     * @date 2020/2/18 21:58
     */
    List<TMsgLog> selectTimeoutMsg();

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
