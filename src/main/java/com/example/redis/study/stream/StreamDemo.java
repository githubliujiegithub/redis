package com.example.redis.study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author chengliujie
 * @date 2020-04-17 8:54
 * @description:
 */
public class StreamDemo {


    public static void main(String[] args) {
        List<String> mylist = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        mylist.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
    }
}
