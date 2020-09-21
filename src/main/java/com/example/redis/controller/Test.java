package com.example.redis.controller;

import com.example.redis.cache.CacheHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengliujie
 * @date 2020-04-08 9:49
 * @description:
 */
@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    private CacheHelper cacheHelper;


    @GetMapping("/num")
    public Integer test() {
        Integer num = cacheHelper.get("num");
        System.out.println(num);

        if (null == num) {
            cacheHelper.set("num", 1);
        } else {
            num++;
            cacheHelper.set("num", num);
        }
        return num;
    }

    @GetMapping("/test1")
    public void test1() {

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(10000);
                    for (int i = 0; i < 100; i++) {
                        System.out.println("11111111111111111111111");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();


    }

    @GetMapping("/test2")
    public void test2() {
        for (int i = 0; i < 100; i++) {
            System.out.println("222222222222222222222222222222222222222222222222222222222222222");
        }
    }

}
