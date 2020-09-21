package com.example.redis.study.clone.shallow;

/**
 * @author chengliujie
 * @date 2020-04-16 15:23
 * @description:
 */
public class Student implements Cloneable {

    // 引用类型
    private Subject subject;
    // 基本类型
    private String name;

    private int age;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "subject=" + subject +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
