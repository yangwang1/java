package com.yangwang.java1;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 对于频繁的插入或删除元素的操作，建议使用 LinkedList 类，效率较高
 * @author yangwang
 * @date 2021-03-05-4:43
 */
public class LinkedListTest {

    /*
       void addFirst (Object obj):添加到首位
       void addLast (Object obj)：添加到末尾
       Object getFirst():获取首位
       Object getLast()：获取末尾
       Object removeFirst()：移除首位
       Object removeLast()：移除末尾
     */

    @Test
    public void test(){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        //void addFirst (Object obj)
        list.addFirst("yangwang");
        System.out.println(list);

        //void addLast (Object obj)
        list.addLast("26");
        System.out.println(list);

        //Object getFirst()
        Object first = list.getFirst();
        System.out.println(first);

        //Object getLast()
        Object last = list.getLast();
        System.out.println(last);

        //Object removeFirst()
        Object o = list.removeFirst();
        System.out.println(o);

        //Object removeLast()
        Object o1 = list.removeLast();
        System.out.println(o1);

    }


}
