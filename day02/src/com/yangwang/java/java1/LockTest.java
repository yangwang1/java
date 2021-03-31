package com.yangwang.java.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决线程安全问题的方式三：lock锁  --->JDK5.0新增
 *
 * 1.面试题：synchronized与lock的不同？
 *   相同：都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        lock需要手动的启动同步lock()，同时结束同步也需要手动的实现unlock()
 * @author yangwang
 * @date 2020-08-14-4:17
 */
public class LockTest {

    public static void main(String[] args) {
        Window w = new Window();
        Thread t = new Thread(w);
        t.setName("窗口1");
        t.start();
    }


}

class Window implements Runnable{

    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while(true) {
            try{
                lock.lock();

                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖出票：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }
        }

    }
}
