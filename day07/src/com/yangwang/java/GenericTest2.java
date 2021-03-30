package com.yangwang.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 *   通配符:?
 *
 *   有限制条件的通配符的使用：
 *     ? extends A : 类型是A或者A的子类
 *     ? super A : 类型是A或者A的父类
 *
 * @author yangwang
 * @date 2021-03-31-0:21
 */
public class GenericTest2 {
    /*
    1.泛型在继承方面的体现
      虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系。
      补充：类A是类B的父类，A<G>是B<G>的父类
     */

    @Test
    public void Test(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] objs = null;
        String[] strs = null;
        objs = strs;

        //虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系。
        ArrayList<Object> list = null;
        ArrayList<String> list2 = null;
        // list = list2; 编译不通过

        //类A是类B的父类，A<G>是B<G>的父类
        List<String> list3 = null;
        ArrayList<String> list4 = null;
        list3 = list4;
    }

    //通配符的使用
    //通配符:?
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);

    }

    public void print(List<?> list){
        if(list == null){
            System.out.println("不能为null");
            return;
        }
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /*
      有限制条件的通配符的使用：
      ? extends A : 类型是A或者A的子类
      ? super A : 类型是A或者A的父类
     */
    @Test
    public void test4(){
        List<? extends Person> list = null;
        List<? super Person> list2 = null;
        List<Person> p = null;
        List<Student> s = null;
        List<Object> o = null;

        list = p;
        list = s;
        //list = o;

        list2 = p;
        //list2 = s;
        list2 = o;

        //Student student = list.get(2);
        Person person = list.get(0);
        Object object = list.get(1);

        //Student student2 = list2.get(2);
        //Person person2 = list2.get(0);
        Object object2 = list2.get(1);

        //list.add(new Student());
        //list.add(new Person());
        //list.add(new Object());

        list2.add(new Student());
        list2.add(new Person());
        //list2.add(new Object());

    }
}
