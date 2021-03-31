package com.yangwang.java.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yangwang
 * @date 2020-12-16-17:56
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yangwang", 20));
        coll.add(new String("tt"));
        coll.add(false);
        System.out.println("---1---");
        //1.contains(obj):判断当前集合是否包含obj
        // 会在判断是调用obj的equals方法
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("tt")));
        System.out.println(coll.contains(new Person("yangwang", 20)));

        System.out.println("---2---");
        //2.containsAll(Collection coll1):判断coll1中的所有元素是否在当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

        System.out.println("---3---");
        //3.remove(obj):从当前集合中移除obj元素
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(new Person("yangwang", 20));
        coll2.add(false);

        coll2.remove(1234);
        System.out.println(coll2);

        coll2.remove(new Person("yangwang", 20));
        System.out.println(coll2);

        System.out.println("---4---");
        //4.removeAll(coll):差集：从当前集合中移除coll中的所有元素
        Collection coll3 = Arrays.asList(123, 456);
        coll2.removeAll(coll3);
        System.out.println(coll2);

        System.out.println("---5---");
        //5.retainAll(coll):交集：获取当前集合和coll集合的交集，值赋给当前集合
        Collection coll4 = Arrays.asList(123, 456, 789);
        coll1.retainAll(coll4);
        System.out.println(coll1);

        System.out.println("---6---");
        //6.equals(obj):当前集合和形参集合的元素都相同，返回ture
        Collection coll5 = new ArrayList();
        coll5.add(123);
        coll5.add(456);
        coll5.add(new Person("yangwang", 20));
        coll5.add(false);

        Collection coll6 = new ArrayList();
        coll6.add(123);
        coll6.add(456);
        coll6.add(new Person("yangwang", 20));
        coll6.add(false);

        System.out.println(coll5.equals(coll6));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yangwang", 20));
        coll.add(new String("tt"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 --->数组:toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合：调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);
        System.out.println(arr1.size()); //1
        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2);
        System.out.println(arr2.size()); //2
    }
}
