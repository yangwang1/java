package com.yangwang.java;

/**
 * 例题：创建三个窗口卖票，总票数100张,使用实现Runnable接口的方式
 * <p>
 * 1.问题：卖票过程中，出现了重票、错票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作了车票
 * 3.如何解决：当一个线程a操作ticket时，其他线程不能参与进来，知道线程a操作完ticket，其他线程才能操作ticket。
 * 这种情况即使线程a出现了阻塞也不能被改变。
 * 4.在java中，我们通过同步机制，来解决线程的安全问题。
 * <p>
 * 方式一：同步代码块
 * <p>
 * synchronized(同步监视器){
 * //需要被同步的代码
 * }
 * 说明：1.操作共享数据的代码即为需要被同步的代码。
 * 2.共享数据：多个线程都要操作的数据，如本题ticket
 * 3.同步监视器，俗称：锁 任何类的对象都能充当锁
 * 要求：多个线程必须用同一把锁
 * 可以考虑使用this做同步监视器
 * <p>
 * 方式二：同步方法
 * <p>
 * 5.同步的方式，解决了线程的安全问题。 ---号出
 * 操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。 ---局限性
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
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖出票：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
