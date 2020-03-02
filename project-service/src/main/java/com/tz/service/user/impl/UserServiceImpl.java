package com.tz.service.user.impl;


import com.alibaba.fastjson.JSONObject;
import com.tz.core.constants.Constants;
import com.tz.core.exception.BusinessException;
import com.tz.core.model.Page;
import com.tz.core.mq.MessageHelper;
import com.tz.core.utils.JodaTimeUtil;
import com.tz.core.utils.RandomUtil;
import com.tz.dao.log.TMsgLogMapper;
import com.tz.dao.log.model.TLoginLog;
import com.tz.dao.log.model.TMsgLog;
import com.tz.dao.user.TUserMapper;
import com.tz.dao.user.model.TUser;
import com.tz.dao.user.req.UserReq;
import com.tz.dao.user.req.UserSaveReq;
import com.tz.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TMsgLogMapper msgLogMapper;

    @Override
    public TUser login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password))
            throw new BusinessException("用户名或密码不能为空");
        TUser user = userMapper.selectByUsernameAndPassword(username, password);
        if (null == user)
            throw new BusinessException("用户名或密码错误");

        // 保存并发送消息
        saveAndSendMsg(user);

        return user;
    }

    /**
     * 保存并发送消息
     * @param user      用户
     * @author KyrieCao
     * @date 2020/2/16 21:54
     */
    private void saveAndSendMsg(TUser user) {
        String msgId = RandomUtil.UUID32();

        // 登录日志
        TLoginLog loginLog = new TLoginLog();
        loginLog.setUserId(user.getId());
        loginLog.setType(Constants.LogType.LOGIN);
        Date now = new Date();
        loginLog.setDescription(user.getUsername() + "在" + JodaTimeUtil.dateToStr(now) + "登录系统");
        loginLog.setCreateTime(now);
        loginLog.setUpdateTime(now);
        loginLog.setMsgId(msgId);

        // 消息日志
        TMsgLog msgLog = new TMsgLog();
        msgLog.setMsgId(msgId);
        msgLog.setMsg(JSONObject.toJSONString(loginLog));
        msgLog.setExchange(Constants.RabbitMqConstants.LOGIN_LOG_EXCHANGE_NAME);
        msgLog.setRoutingKey(Constants.RabbitMqConstants.LOGIN_LOG_ROUTING_KEY_NAME);
        msgLog.setTryCount(0);
        msgLog.setStatus(Constants.MsgLogStatus.DELIVERING);
        msgLog.setCreateTime(now);
        msgLog.setUpdateTime(now);
        msgLog.setNextTryTime(JodaTimeUtil.plusMinutes(now,1));
        msgLogMapper.insert(msgLog);

        // 发送消息
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplate.convertAndSend(Constants.RabbitMqConstants.LOGIN_LOG_EXCHANGE_NAME, Constants.RabbitMqConstants.LOGIN_LOG_ROUTING_KEY_NAME, MessageHelper.objToMsg(loginLog), correlationData);
    }

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