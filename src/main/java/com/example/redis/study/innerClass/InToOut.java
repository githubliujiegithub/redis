package com.example.redis.study.innerClass;

/**
 * @author chengliujie
 * @date 2020-04-16 9:02
 * @description: 内部访问外部类
 */
// 非静态内部类的非静态方法

//public class InToOut {
//
//    int i = 9;
//    static String str = "jjj";
//
//    class Inner{
//        void study (){
//            System.out.println(i);
//            System.out.println(str);
//        }
//    }
//}

// 静态内部类的非静态方法

//public class InToOut {
//
//    int i = 9;
//    static String str = "jjj";
//
//    static class Inner{
//        void study (){
//            System.out.println(new InToOut().i);
//            System.out.println(str);
//        }
//    }
//}

// 静态内部类的静态方法

public class InToOut {

    int i = 9;
    static String str = "jjj";

    static class Inner {
        static void test() {
            System.out.println(new InToOut().i);
            System.out.println(str);
        }
    }
}
