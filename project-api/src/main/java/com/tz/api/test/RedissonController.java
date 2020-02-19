package com.tz.api.test;

import com.tz.core.model.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁测试接口
 * @author KyrieCao
 * @date 2020/2/19 21:15
 */
@Api(tags = "分布式锁测试接口")
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 获取分布式锁测试
     * @return ApiResponse<String>
     * @author KyrieCao
     * @date 2020/2/19 21:24
     */
    @ApiOperation("获取分布式锁测试")
    @GetMapping("/getRedisson")
    public ApiResponse<String> getRedisson() {
        RLock lock = redissonClient.getLock("redissonLock");
        boolean locked = false;
        try {
            locked = lock.tryLock(0, 10, TimeUnit.SECONDS);
            if (locked) {
                Thread.sleep(100);
                return new ApiResponse<String>().success("获取锁成功");
            } else {
                return new ApiResponse<String>().failed("获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new ApiResponse<String>().failed("获取锁异常");
        } finally {
            if (!locked) {
                return new ApiResponse<String>().failed("获取锁失败");
            }
            lock.unlock();
        }
    }
}
