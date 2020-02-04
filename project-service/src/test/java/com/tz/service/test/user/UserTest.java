package com.tz.service.test.user;

import com.tz.dao.user.model.TUser;
import com.tz.service.test.BaseTest;
import com.tz.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户业务测试
 * @author KyrieCao
 * @date 2020/2/4 17:23
 */
@Slf4j
@EnableAutoConfiguration
@SpringBootTest(classes = UserTest.class)
public class UserTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByIdTest() {
        TUser user = userService.findById(1);
        System.out.println("用户名：" + user.getUsername());
    }

}
