package com.msb.test05;

public class Test {
    public static void main(String[] args) {
        //1.main方法作为程序的入口，里面执行的任务就是主线程的任务:
        for (int i = 1; i <= 100; i++) {
            System.out.println("main---" + i);
        }

        //6.创建子线程对象，执行任务
        TestThread t = new TestThread();
        //7.执行任务,不是直接调用run，而是启动线程
         t.start();//8.子线程启动，会和主线程抢资源


        //9.主线程再加一个循环
        for (int i = 1; i <= 100; i++) {
            System.out.println("main---main---" + i);
        }
    }
}
