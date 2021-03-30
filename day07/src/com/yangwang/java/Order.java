package com.yangwang.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
 * 换句话说，泛型方法所属的类是不是泛型类都没有关系。
 *
 * @author yangwang
 * @date 2021-03-30-23:07
 */
public class Order<T> {
    int age;
    String name;

    //类有泛型，类内部就可以使用泛型
    T orderT;

    public Order() {
    }

    public Order(int age, String name, T orderT) {
        this.age = age;
        this.name = name;
        this.orderT = orderT;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", orderT=" + orderT +
                '}';
    }

    public <E> List<E> copyFromArrayToList(E[] array){
        ArrayList<E> list = new ArrayList<>();
        for (E e: array) {
            list.add(e);
        }
        return list;
    }
}
