package com.yangwang.java;

/**
 * @author yangwang
 * @date 2020-08-13-3:31
 * <p>
 * 测试Thread常用方法
 * 1.start():启动当前线程并调用run方法
 * 2.run():通常需要重写该方法,把线程需要执行的操作写在里面
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名称
 * 5.setName():设置当前线程的名称
 * 6.yield():线程让步,释放当前cpu的执行权
 * 7.join():在线程a调用线程b的join()，瓷实线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
 * 8.stop():已过时，当执行此方法，线程强制结束
 * 9.sleep():静态方法，让当前线程睡眠指定的毫秒数 1秒等于1000毫秒，在指定的毫秒内，当前线程处于阻塞状态。
 * 10.isAlive():当前线程是否还存活
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5  ->默认优先级是5
 * 2.如何获取和设置当前线程的优先级：
 * getPriority():获取线程的优先级
 * setPriority(int p):设置线程的优先级
 *
 * 说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率被执行，并不意味着一定优先执行。
 */
public class ThreadMethodTest {

    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1("线程1");
        System.out.println(mt1.getName());
        mt1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority() +
                        ": " + i);
            }

            if (i == 20) {
                try {
                    mt1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(mt1.isAlive());
    }
}

class MyThread1 extends Thread {
    public MyThread1() {
    }

    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ": " + getPriority() + ": " + i);
            }

            if (i % 20 == 0) {
                yield();
            }
        }

        System.out.println(isAlive());
    }
}
