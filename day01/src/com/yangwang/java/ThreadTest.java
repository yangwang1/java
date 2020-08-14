package com.yangwang.java;

/**
 * @author yangwang
 * @date 2020-08-13-2:33
 * 多线程的创建：方式一
 * 1、继承Thread类
 * 2、重写run方法
 * 3、创建线程对象
 * 4、执行start方法:1.启动当前线程2.调用当前线程的run方法
 * <p>
 * 例题：在线程中输出100以内的偶数
 */

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "******");
            }
        }
    }
}
