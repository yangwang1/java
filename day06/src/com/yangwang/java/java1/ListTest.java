package com.yangwang.java.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *     1.List接口:存储有序的、可重复的数据。  -->“动态”数组
 *       ----ArrayList、LinkedList、Vector
 *     2.ArrayList的源码分析：
 *     2.1 jdk7情况下
 *       ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *       list.add(123);//elementData[0] = new Integer(123);
 *       ...
 *       list.add(11);//如果此次的添加导致底层elementData数组容量不够,则扩容。
 *       默认情况下，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *       结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *     2.2 jdk8中ArrayList的变化：
 *       ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的Object[]
 *       list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
 *       。。。
 *       后续的添加和扩容操作与jdk7一样。
 *     2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象的创建类似于
 *              单例的懒汉式，延迟了数据的创建，节省内存。
 *     3.LinkedList的源码分析：
 *       LinkedList list = new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 *       List.add(123);//将123封装到Node中，创建了Node对象。Node的定义体现了LinkedList的双向链表的说法
 *     4.Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组，在扩容方面，
 *       默认扩容为原来的数组长度的2倍。
 *
 *
 *     面试题：ArrayList、LinkedList、Vector三者的异同？
 *     同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *     不同：ArrayList：作为List接口的主要实现类；线程不安全，效率高：底层使用Object[]存储
 *          LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高;底层使用双向链表存储
 *          Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[]存储
 *
 * @author yangwang
 * @date 2020-12-29-2:59
 */
public class ListTest {

    /*
     void add(int index, Object ele):在index位置插入ele元素
     boolean addAll(int index, Collextion eles):从index位置开始将eles中的所有元素添加进来
     Object get(int index)：获取指定index位置的元素
     int indexOf(Object obj):返回obj在集合中首次出现的位置
     int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     Object remove(int index):移除指定index位置的元素，并返回此元素
     Object set(int index,Object ele):设置指定index位置的元素为ele
     List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

     总结：常用方法
     增：add(Object obj)
     删：remove(int index)/remove(Object obj)
     改：set(int index, Object ele)
     查：get(int index)
     插：add(int index, Object ele)
     长度：size()
     遍历：1.Iterator迭代器方式
          2.增强for循环
          3.普通的循环
     */

    @Test
    public void test2( ){
        ArrayList l1 = new ArrayList();
        l1.add("yangwang");
        l1.add("26");

        //1.Iterator迭代器方式
        Iterator iterator = l1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //2.增强for循环
        for (Object obj: l1) {
            System.out.println(obj);
        }

        //3.普通的循环
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }
    }

    @Test
    public void test( ){

        ArrayList l1 = new ArrayList();
        l1.add("yangwang");
        l1.add("26");

        // void add(int index, Object ele):在index位置插入ele元素
        l1.add(1,"tianjin");
        System.out.println(l1);
        List l2 =Arrays.asList(1,2,3);

        // boolean addAll(int index, Collextion eles):从index位置开始将eles中的所有元素添加进来
        l1.addAll(l2);
        System.out.println(l1);

        // Object get(int index)：获取指定index位置的元素
        Object o = l1.get(1);
        System.out.println(o);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        int i = l1.indexOf("26");
        System.out.println(i);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        l1.add("26");
        int i1 = l1.lastIndexOf("26");
        System.out.println(i1);

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object remove = l1.remove(6);
        System.out.println(remove);
        System.out.println(l1);

        //Object set(int index,Object ele):设置指定index位置的元素为ele
        Object set = l1.set(3, 4);
        System.out.println(set);
        System.out.println(l1);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合,左闭右开
        List list = l1.subList(1, 3);
        System.out.println(list);
    }
}
