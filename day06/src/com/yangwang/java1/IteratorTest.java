package com.yangwang.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部方法：hasNext()和next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 *   默认游标都在集合的第一个元素之前
 * 3.内部定义了remove()，可以在便利的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 *
 * @author yangwang
 * @date 2020-12-28-20:47
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yangwang", 20));
        coll.add(new String("tt"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一:不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }
        //方式二：推荐
        //hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next():1.指针下移 2.将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yangwang", 20));
        coll.add(new String("tt"));
        coll.add(false);

        //错误方式一：调一次next指针就往下走一次
//        Iterator iterator = coll.iterator();
//        while ((iterator.next() != null)) {
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }

    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yangwang", 20));
        coll.add(new String("tt"));
        coll.add(false);

        //删除集合中的"tt"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("tt".equals(obj)) {
                iterator.remove();
            }
        }
        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
