package com.example.redis.controller;

/**
 * @author chengliujie
 * @date 2020-06-12 17:04
 * @description:
 */
public class Main {

    public static void main(String[] args) {

        Thread thread1 = new myThread();
        thread1.start();
        System.out.println(Thread.currentThread().getName());
        Thread thread = new myThread();
        thread.run();

    }
}

class myThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
