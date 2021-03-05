package com.yangwang.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0新增增强for循环可以遍历集合和数组
 *
 * @author yangwang
 * @date 2020-12-28-21:41
 */
public class ForTest {

    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("yangwang", 20));
        coll.add(new String("tt"));
        coll.add(false);

        //for(集合元素的类型 局部变量：集合对象)
        //内部仍然调用了迭代器
        for (Object col : coll) {
            System.out.println(col);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //for(数组元素的类型 局部变量：数组对象)
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};

        //方式一:普通for赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "GG";
        }

        //方式二：增强for循环
        for (String s : arr) {
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
