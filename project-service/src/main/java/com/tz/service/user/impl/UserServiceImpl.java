package com.tz.service.user.impl;


import com.tz.core.constants.Constants;
import com.tz.core.exception.BusinessException;
import com.tz.core.model.Page;
import com.tz.dao.user.TUserMapper;
import com.tz.dao.user.model.TUser;
import com.tz.dao.user.req.UserReq;
import com.tz.dao.user.req.UserSaveReq;
import com.tz.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表业务实现
 * @author KyrieCao
 * @date 2020/02/04 14:59
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public Page<TUser> findPage(UserReq req) {
        Page<TUser> page = new Page<>();
        // 如果存在页码，则查询总数
        if (req.getPageIndex() != null) {
            int total = userMapper.countBySelective(req);
            page.setPageIndex(req.getPageIndex());
            page.setPageSize(req.getPageSize());
            page.setTotal(total);
        }
        // 查询数据
        List<TUser> userList = userMapper.selectBySelective(req);
        page.setResult(userList);
        return page;
    }

    @Override
    public TUser findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public TUser create(UserSaveReq req) {
        if (req == null) throw new BusinessException("非法操作");
        if (StringUtils.isBlank(req.getUsername())) throw new BusinessException("用户名不能为空");
        if (StringUtils.isBlank(req.getPassword())) throw new BusinessException("密码不能为空");
        TUser user = new TUser();
        BeanUtils.copyProperties(req, user);
        int resultNum = userMapper.insertSelective(user);
        if (resultNum == 0)
            throw new BusinessException(Constants.Status.CREATE_FAILURE);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        TUser user = findById(id);
        if (user == null) throw new BusinessException(Constants.Status.DATA_EMPTY);
        int resultNum = userMapper.deleteByPrimaryKey(id);
        if (resultNum == 0) throw new BusinessException(Constants.Status.DELETE_FAILURE);
    }

    @Override
    public void updateById(UserSaveReq req) {
        TUser user = new TUser();
        BeanUtils.copyProperties(req, user);
        int resultNum = userMapper.updateByPrimaryKeySelective(user);
        if(resultNum == 0) throw new BusinessException(Constants.Status.UPDATE_FAILURE);
    }
}