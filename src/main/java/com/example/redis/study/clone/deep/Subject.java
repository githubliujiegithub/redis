package com.example.redis.study.clone.deep;

/**
 * @author chengliujie
 * @date 2020-04-16 15:09
 * @description:
 */
public class Subject implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }
}
