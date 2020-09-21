package com.example.redis.study.design.factory;

/**
 * @author chengliujie
 * @date 2020-04-16 10:48
 * @description: 山地自行车
 */
public class MBike implements Bike {
    @Override
    public void ride() {

        System.out.println("我是山地自行车");
    }
}
