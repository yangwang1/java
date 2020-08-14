package com.yangwang.java;

/**
 * @author yangwang
 * @date 2020-08-13-4:27
 * <p>
 * 例题：创建三个窗口卖票，总票数100张
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window3 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {

        while (true) {
            show();
        }
    }

    public static synchronized void show() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出：" + ticket);
            ticket--;
        }
    }
}
