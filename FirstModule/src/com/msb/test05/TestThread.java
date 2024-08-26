package com.msb.test05;

/**
 * 2.创建一个线程类
 * 3.多线程能力->extends Thread
 */
public class TestThread extends Thread{
    @Override
    public void run(){
        //5.线程任务:输出10个数
        for (int i = 1; i <= 100; i++) {
            System.out.println("子线程---" + i);
        }
    }
}
