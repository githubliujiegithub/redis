package com.example.redis.study.serializableDemo;

/**
 * @author chengliujie
 * @date 2020-04-13 16:45
 * @description: 装箱和拆箱
 */

public class IntegerAndInt {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int i = 40;
        int i0 = 40;
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        Double d1 = 1.0;
        Double d2 = 1.0;

        System.out.println("i=i0\t" + (i == i0));
        // int类型只要在-128到127之间的自动装箱都是从缓存中获取的
        System.out.println("i1=i2\t" + (i1 == i2));
        // 只要计算先拆箱成int，所以不管结果是否在-128到127，都为true
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        // 它们的内存地址不一样
        System.out.println("i4=i5\t" + (i4 == i5));
        // 拆箱
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));
        // double的装箱没有使用缓存，没吃都是new，所以false，float也一样
        System.out.println("d1=d2\t" + (d1 == d2));

        char a1 = 'A';
        char a2 = 'A';
        Character c1 = new Character('C');
        Character c2 = new Character('C');
        System.out.println("a1=a2\t" + (a1 == a2));
        System.out.println("c1=c2\t" + (c1 == c2));

    }
}
