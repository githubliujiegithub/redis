package com.example.redis.study;

import java.util.function.Function;

/**
 * @author chengliujie
 * @date 2020-04-09 16:43
 * @description:
 */
public class Test {

    public static void main(String[] args) {

        Function<Test2, String> getAge = Test2::getAge;


    }

    public void test(int b) {
        int a = 10;
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println(a);
//            }
//        }.start();
        new Thread(() -> System.out.println("jjj")).start();
    }
}

