package com.tz.dao.log;

import com.tz.dao.log.model.TLoginLog;
import com.tz.dao.log.model.TLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLoginLogMapper {
    int countByExample(TLoginLogExample example);

    int deleteByExample(TLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLoginLog record);

    int insertSelective(TLoginLog record);

    List<TLoginLog> selectByExample(TLoginLogExample example);

    TLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLoginLog record, @Param("example") TLoginLogExample example);

    int updateByExample(@Param("record") TLoginLog record, @Param("example") TLoginLogExample example);

    int updateByPrimaryKeySelective(TLoginLog record);

    int updateByPrimaryKey(TLoginLog record);
}