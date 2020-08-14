package com.yangwang.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的鯮姐：
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显式的生命
 * 2.非静态的同步方法，同步监视器是:this
 *   静态的同步方法，同步监视器是:当前类本身
 * @author yangwang
 * @date 2020-08-14-3:13
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w2 = new Window2();
        Thread t1 = new Thread(w2);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {

        while (true) {
            show();
        }
    }

    public synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖出票：" + ticket);
            ticket--;
        }
    }
}
