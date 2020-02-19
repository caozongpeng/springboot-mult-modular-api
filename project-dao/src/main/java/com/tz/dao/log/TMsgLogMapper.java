package com.tz.dao.log;

import com.tz.dao.log.model.TMsgLog;
import com.tz.dao.log.model.TMsgLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("msgLogMapper")
public interface TMsgLogMapper {

    /**
     * 查询发送失败消息
     * @return List<TMsgLog>
     * @author KyrieCao
     * @date 2020/2/18 21:58
     */
    List<TMsgLog> selectTimeoutMsg();

    int countByExample(TMsgLogExample example);

    int deleteByExample(TMsgLogExample example);

    int deleteByPrimaryKey(String msgId);

    int insert(TMsgLog record);

    int insertSelective(TMsgLog record);

    List<TMsgLog> selectByExampleWithBLOBs(TMsgLogExample example);

    List<TMsgLog> selectByExample(TMsgLogExample example);

    TMsgLog selectByPrimaryKey(String msgId);

    int updateByExampleSelective(@Param("record") TMsgLog record, @Param("example") TMsgLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TMsgLog record, @Param("example") TMsgLogExample example);

    int updateByExample(@Param("record") TMsgLog record, @Param("example") TMsgLogExample example);

    int updateByPrimaryKeySelective(TMsgLog record);

    int updateByPrimaryKeyWithBLOBs(TMsgLog record);

    int updateByPrimaryKey(TMsgLog record);
}