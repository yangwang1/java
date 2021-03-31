package com.yangwang.java.exer;

/**
 * @author yangwang
 * @date 2020-08-13-3:11
 * <p>
 * 例题：创建两个分线程，一个遍历100以内的偶数，一个遍历100以内的奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        mt1.start();

        MyThread2 mt2 = new MyThread2();
        mt2.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("偶数：" + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("奇数：" + i);
            }
        }
    }
}
