package com.yangwang.exer;

/**
 * @author yangwang
 * @date 2020-08-13-3:19
 * <p>
 * 例题：创建两个分线程，一个遍历100以内的偶数，一个遍历100以内的奇数
 */
public class ThreadDemo2 {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                ThreadDemo2 td = new ThreadDemo2();
                td.number(false);
//                for (int i = 0; i < 100; i++) {
//                    if (i % 2 == 0) {
//                        System.out.println("偶数：" + i);
//                    }
//                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                ThreadDemo2 td = new ThreadDemo2();
                td.number(true);
//                for (int i = 0; i < 100; i++) {
//                    if (i % 2 != 0) {
//                        System.out.println("奇数：" + i);
//                    }
//                }
            }
        }.start();
    }

    public void number(boolean isOddNumber) {
        for (int i = 0; i < 100; i++) {
            if (isOddNumber) {
                if (i % 2 != 0) {
                    System.out.println("奇数：" + i);
                }
            } else {
                if (i % 2 == 0) {
                    System.out.println("偶数：" + i);
                }
            }
        }
    }
}
