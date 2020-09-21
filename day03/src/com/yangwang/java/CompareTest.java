package com.yangwang.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * java实现排序的两种方式
 * 1.自然排序： java.lang.Comparable
 * 2.定制排序： java.util.Comparator
 *
 * @author yangwang
 * @date 2020-08-27-11:38
 */
public class CompareTest {

    public static void main(String[] args) {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("红楼梦", 100);
        goods[1] = new Goods("西游记", 80);
        goods[2] = new Goods("水浒传",120);
        goods[3] = new Goods("三国演义",70);

        System.out.println(goods[0].compareTo(goods[1]));
        Arrays.sort(goods);  //Goods类需要实现Comparable

        System.out.println(Arrays.toString(goods));

        Arrays.sort(goods,new MyComparator()); //Goods类不需要实现Comparable，这里懒得重新定义一个类，所以复用了上面的

        System.out.println(Arrays.toString(goods));
    }


}

class Goods implements Comparable {

    private String name;
    private double price;

    public Goods(String name, double price){
        this.price = price;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods other = (Goods) o;
            if (this.price > other.price) {
                return 1;
            } else if (this.price < other.price) {
                return -1;
            }

            return 0;
        }

        throw new RuntimeException("输入的数据类型不一致");
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }
}

class MyComparator implements Comparator {

    private String name;
    private double price;

    @Override
    public String toString() {
        return "Goods2{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Goods && o2 instanceof Goods){

            return ((Goods) o1).getName().compareTo(((Goods) o2).getName());
        }

        throw new RuntimeException("输入的数据类型不一致");
    }
}
