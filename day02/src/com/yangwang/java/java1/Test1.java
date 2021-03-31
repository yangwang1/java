package com.yangwang.java.java1;

/**
 * 练习：
 * 银行有一个账户
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额
 * <p>
 * 分析：
 * 1.是否是多线程问题？是，有两个储蓄线程
 * 2.是否有共享数据？有，账户余额
 * 3.是否有线程安全问题？有
 * 4.需要考虑如何解决线程安全问题？同步机制：有三种方式
 *
 * @author yangwang
 * @date 2020-08-14-4:38
 */
public class Test1 {

    public static void main(String[] args) {
        Account acc = new Account(0);
        Customer c1 = new Customer(acc);
        Customer c2 = new Customer(acc);

        c1.setName("杨旺");
        c2.setName("霍甜甜");

        c1.start();
        c2.start();
    }

}

class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存款成功，余额为：" + balance);
        }
    }

}

class Customer extends Thread {

    Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.deposit(1000);
        }
    }
}


