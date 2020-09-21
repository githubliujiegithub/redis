package com.example.redis.study.clone.shallow;

/**
 * @author chengliujie
 * @date 2020-04-16 15:09
 * @description:
 */
public class Subject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }
}
