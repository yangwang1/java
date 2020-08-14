package com.yangwang.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池
 * 好处：
 * 1.提高响应速度 （减少了创建新线程的时间）
 * 2.降低资源消耗 （重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *   corePoolSize ：核心池的大小
 *   maximumPoolSize ：最大线程数
 *   keepAliveTime ：线程没有任务时最多保持多长时间后会 终止
 *
 * @author yangwang
 * @date 2020-08-15-1:13
 */
public class ThreadPool {
    public static void main(String[] args) {
        NumThread2 numThread2 = new NumThread2();
        Window1 window = new Window1();
        //1.指定线程数量
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            //2.执行指定的线程的操作，需提供callable接口或runnable接口的实现类
            Object num = service.submit(numThread2).get();  //适用于callable接口，能获取返回值
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.execute(window); //适用于runnable接口

        service.shutdown();
    }
}

class NumThread2 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
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
