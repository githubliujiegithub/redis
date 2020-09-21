package com.example.redis.study.design.factory;

/**
 * @author chengliujie
 * @date 2020-04-16 10:49
 * @description:
 */
public class RBike implements Bike {
    @Override
    public void ride() {
        System.out.println("我是公路自行车");
    }
}
