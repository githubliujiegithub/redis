package com.example.redis.study.clone.deep;

/**
 * @author chengliujie
 * @date 2020-04-16 15:24
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.setName("语文");

        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("小明");
        studentA.setAge(18);

        Student studentB = (Student) studentA.clone();
        studentB.setName("小B");
        studentB.setAge(19);
        // 修改引用值
        Subject subjectB = studentB.getSubject();
        subjectB.setName("数学");

//        subject.setName("英语");
        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }
}
