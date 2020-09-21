package com.example.redis.study.innerClass;

/**
 * @author chengliujie
 * @date 2020-04-16 9:23
 * @description: 外部类访问内部类
 */

// 非静态方法访问非静态内部类

//public class OutToIn {
//    void study() {
//        System.out.println(new Inner().i);
//    }
//    class Inner{
//        int i = 9;
//        // 定义错误
////        static String str = "静态";
//    }
//}

// 非静态方法访问静态内部类

//public class OutToIn {
//    void study() {
//        System.out.println(new Inner().i);
//        System.out.println(Inner.str);
//    }
//    static class Inner{
//        int i = 9;
//        static String str = "静态";
//    }
//}

// 静态方法访问静态内部类

//public class OutToIn {
//    static void study() {
//        System.out.println(new Inner().i);
//        System.out.println(Inner.str);
//    }
//    static class Inner{
//        int i = 9;
//        static String str = "静态";
//    }
//}

// 静态方法访问非静态内部类

public class OutToIn {
    static void test() {
        System.out.println(new OutToIn().new Inner().i);
    }

    class Inner {
        int i = 9;
//        static String str = "静态";
    }
}
