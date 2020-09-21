package com.example.redis;

import com.example.redis.study.async.Task;
import com.example.redis.study.async.VoidTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
@Slf4j
class RedisApplicationTests {

    @Autowired
    private Task task;

    @Autowired
    private VoidTask voidTask;

    @Test
    void taskTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> taskOne = task.doTaskOne();
        Future<String> taskTwo = task.doTaskTwo();
        Future<String> taskThree = task.doTaskThree();

        while (true) {
            if (taskOne.isDone() && taskTwo.isDone() && taskThree.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        log.info("总耗时：" + (end - start) + "毫秒");
    }

    @Test
    void voidTask() throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            voidTask.doTaskOne();
            voidTask.doTaskTwo();
            voidTask.doTaskThree();
            if (i == 999) {
                log.info("关闭");
                System.exit(0);
            }
        }
    }
}
