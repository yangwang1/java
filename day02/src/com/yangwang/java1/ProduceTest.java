package com.yangwang.java1;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 * <p>
 * 生产者（Productor）将产品交给店员（Clerk，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品（比如20），如果生产者试图生产更多的产品，店员会叫
 * 生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员
 * 会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析
 * 1.是否是多线程问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，店员（或产品）
 * 3.如何解决线程的安全问题？同步机制，有三种方法
 * 4.是否涉及线程通信？是
 * <p>
 * producer customer clerk
 *
 * @author yangwang
 * @date 2020-08-14-23:31
 */
public class ProduceTest {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer1 customer = new Customer1(clerk);
        Customer1 customer2 = new Customer1(clerk);


        producer.setName("生产者1");
        customer.setName("消费者1");
        customer2.setName("消费者2");

        producer.start();
        customer.start();
        customer2.start();
    }
}

class Clerk {

    private int productCount = 0;

    public synchronized void produce() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "生产了" + productCount + "号产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void custom() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "消费了" + productCount + "号产品");
            productCount--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}

class Customer1 extends Thread {
    private Clerk clerk;

    public Customer1(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.custom();
        }
    }
}
