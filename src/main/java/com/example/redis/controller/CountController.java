package com.example.redis.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {

    int i = 0;

    @RequestMapping("/count")
    public void testCount() {
        i++;
        System.out.println(i);
    }
}
