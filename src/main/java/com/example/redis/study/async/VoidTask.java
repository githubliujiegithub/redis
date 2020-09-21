package com.example.redis.study.async;

import com.example.redis.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author chengliujie
 * @date 2020-06-16 14:22
 * @description:
 */
@Component
@Slf4j
public class VoidTask {

    public static Random random = new Random();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Async("taskExecutor")
    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        log.info(redisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务一耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        log.info(redisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务二耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws InterruptedException {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        log.info(redisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务三耗时：" + (end - start) + "毫秒");
    }
}
