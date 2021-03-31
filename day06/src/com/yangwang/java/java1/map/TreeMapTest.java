package com.yangwang.java.java1.map;

import com.yangwang.java.java1.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author yangwang
 * @date 2021-03-30-18:13
 */
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序

    //自然排序
    @Test
    public void test() {
        TreeMap<Person, Integer> map = new TreeMap<>();
        Person p1 = new Person("tom", 12);
        Person p2 = new Person("jim", 11);
        Person p3 = new Person("jack",8);

        map.put(p1,22);
        map.put(p2,55);
        map.put(p3,34);

        System.out.println(map);
    }

    //定制排序
    @Test
    public void test2(){
        TreeMap<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        Person p1 = new Person("tom", 12);
        Person p2 = new Person("jim", 11);
        Person p3 = new Person("jack",13);

        map.put(p1,22);
        map.put(p2,55);
        map.put(p3,34);

        System.out.println(map);
    }
}
