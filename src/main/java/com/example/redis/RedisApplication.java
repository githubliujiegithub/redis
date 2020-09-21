package com.example.redis;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class RedisApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(RedisApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);// 关闭启动头
        springApplication.run(args);
    }

}
