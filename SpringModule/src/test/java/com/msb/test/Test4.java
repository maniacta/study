package com.msb.test;

import com.msb.pojo.Girl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        //创建Spring容器:
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //获取对象:
        Girl g = (Girl) context.getBean("girl");
        System.out.println("girl:"+g.getName()+" LOVE boy:"+g.getBoyfriend().getName());
//        System.out.println(g.getName());
//        System.out.println(g.getAge());
//        System.out.println(g.getBoyfriend());
    }
}
