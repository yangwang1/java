package com.yangwang.java;
import org.junit.Test;

import java.util.List;

/**
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型
 *   总结：
 *   1.集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *   2.在实例化集合类时，可以指明具体的泛型类型
 *   3.指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如:方法、构造器、属性等）使用到
 *     类的泛型的位置，都指定为实例化的泛型类型。
 *   4.注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类代替。
 *   5.如果实例化时，没有指明泛型的类型，默认类型为Object类型。
 *
 * 3.泛型的注意：
 *   静态类和方法不能有类的泛型：泛型是实例化之后确定类型，静态结构在实例化之前
 *   泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
 *   异常不能有泛型
 * @author yangwang
 * @date 2021-03-30-19:26
 */
public class GenericTest {

    //自定义泛型类的测试
    @Test
    public void test(){

        Order<String> order = new Order<String>();
        order.setAge(11);
        order.setName("tom");
        order.setOrderT("tianjin");
        System.out.println(order);

    }

    @Test
    public void test1(){
        SubOrder order = new SubOrder();
        order.setOrderT("tianjin");
        SubOrder2<String> order2 = new SubOrder2<>();
        order2.setOrderT("tianjin");
    }

    //测试泛型方法
    @Test
    public void test2(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[] {1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
