package com.example.redis.study.design;

/**
 * @author chengliujie
 * @date 2020-04-16 10:11
 * @description: 单例模式
 */

// 懒汉式写法

//public class Singleton {
//
//    private static Singleton singleton;
//    // 构造函数私有
//
//    private Singleton(){}
//
//    public static synchronized Singleton getInstance() {
//
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//
//        return singleton;
//    }
//}

// 饿汉式写法

//public class Singleton {
//
//    private static Singleton singleton = new Singleton();
//
//    private Singleton(){}
//
//    public Singleton getInstance() {
//        return singleton;
//    }
//}


// 静态内部类单例模式 经常使用

//public class Singleton {
//
//    private Singleton() {
//    }
//
//    public static final Singleton getInstance() {
//
//        return SingletonHolder.INSTANCE;
//    }
//
//    private static class SingletonHolder {
//
//        private static final Singleton INSTANCE = new Singleton();
//    }
//}

/**
 * 双重校验锁实现单例
 */
public class Singleton{

    private volatile static Singleton singleton;
    private Singleton(){}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}