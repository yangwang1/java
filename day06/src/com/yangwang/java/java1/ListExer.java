package com.yangwang.java.java1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 一个小面试题
 *
 * @author yangwang
 * @date 2021-03-05-4:28
 */
public class ListExer {

    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    public void updateList(List list){
        list.remove(2); //结果1 2
//        list.remove(new Integer(2)); //结果1 3
    }
}
