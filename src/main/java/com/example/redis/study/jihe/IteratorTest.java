package com.example.redis.study.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(54);
        list.add(43);
        list.add(3);
        list.remove(1);
        Iterator<Integer> iterator = list.iterator();
        if (iterator.hasNext()) {
            if (iterator.next() == 1) {
                iterator.remove();
            }
        }
        System.out.println(list);

    }
}
