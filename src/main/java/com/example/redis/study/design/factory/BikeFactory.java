package com.example.redis.study.design.factory;

/**
 * @author chengliujie
 * @date 2020-04-16 10:49
 * @description: 工厂类
 */
public class BikeFactory {

    public Bike getBike(String bikeType) {
        if (bikeType == null) {
            return null;
        }
        if ("MBike".equalsIgnoreCase(bikeType)) {
            return new MBike();
        }
        if ("RBike".equalsIgnoreCase(bikeType)) {
            return new RBike();
        }

        return null;
    }
}
