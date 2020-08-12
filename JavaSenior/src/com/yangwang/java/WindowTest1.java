package com.yangwang.java;

/**
 * 例题：创建三个窗口卖票，总票数100张,使用实现Runnable接口的方式
 *
 * @author yangwang
 * @date 2020-08-13-4:53
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {

        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出票：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
