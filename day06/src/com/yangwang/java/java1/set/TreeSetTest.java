package com.yangwang.java.java1.set;

import com.yangwang.java.java1.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yangwang
 * @date 2021-03-06-3:47
 */
public class TreeSetTest {

    /*
    1.向TreeSet中添加的数据，要求是相同类的对象。
    2.两种排序方式：自然排序(实现Comparable接口)和定制排序(实现Comparator)
    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()
     */

    @Test
    public void test() {
        TreeSet set = new TreeSet();
        set.add(new Person("tom", 26));
        set.add(new Person("jack", 11));
        set.add(new Person("ma", 33));

        System.out.println(set);

    }

    @Test
    public void test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof  Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;

                    return Integer.compare(p1.getAge(),p2.getAge());
                } else {
                    throw new RuntimeException("输入的数据不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new Person("tom", 26));
        set.add(new Person("jack", 11));
        set.add(new Person("ma", 33));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
