package com.tz.service.test;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试基类
 * @author KyrieCao
 * @date 2020/2/4 17:23
 */
@RunWith(SpringRunner.class)
@MapperScan("com.tz.dao")
@ComponentScan("com.tz")
public class BaseTest {
}
