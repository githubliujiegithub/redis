package com.example.redis.study.design.factory;

/**
 * @author chengliujie
 * @date 2020-04-16 10:52
 * @description:
 */
public class Test {

    public static void main(String[] args) {

        BikeFactory bikeFactory = new BikeFactory();

        Bike bike1 = bikeFactory.getBike("MBike");
        bike1.ride();

        Bike bike2 = bikeFactory.getBike("RBike");
        bike2.ride();
    }
}
