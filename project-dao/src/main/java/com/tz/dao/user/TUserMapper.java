package com.tz.dao.user;

import com.tz.dao.user.model.TUser;
import com.tz.dao.user.model.TUserExample;
import java.util.List;

import com.tz.dao.user.req.UserReq;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface TUserMapper {

    /**
     * 动态查询统计
     * @param req       查询对象
     * @author KyrieCao
     * @date 2020/2/4 16:44
     */
    int countBySelective(UserReq req);

    /**
     * 动态查询
     * @param req       查询对象
     * @return List<TUser>
     * @author KyrieCao
     * @date 2020/2/4 16:45
     */
    List<TUser> selectBySelective(UserReq req);

    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}