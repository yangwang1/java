package com.yangwang.java.java1;

/**
 * @author yangwang
 * @date 2020-08-14-3:40
 */
public class BankTest {

    public static void main(String[] args) {
        Bank.getInstance();
    }
}

class Bank {
    private static Bank instance = null;

    public static Bank getInstance() {

        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }

        return instance;
    }
}
