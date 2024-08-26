package com.msb.test01;

/**
 * 人类
 */
public class Person {
    //    特性-属性
    String name; //姓名
    int age; //年龄
    double height; //身高

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    //    行为-方法
    public void study() {
        System.out.println("我爱学习");
    }
}
