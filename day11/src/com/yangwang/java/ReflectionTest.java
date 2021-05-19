package com.yangwang.java;

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * 关于java.lang.Class类的理解
 * 1.类的加载过程：
 *  程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
 *  接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程
 *  就称为类的加载。加载到内存中的类。我们就称为运行时类，此运行时类，就作为class的一个实例。
 * 2.换句话说，class的实例就对应着一个运行时类。
 * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
 *
 * @author yangwang
 * @date 2021-04-02-3:15
 */
public class ReflectionTest {

    //获取class的实例的方式(前三种方式需要掌握)
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三：调用class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.yangwang.java.Person");
        System.out.println(clazz3);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.yangwang.java.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);

    }


    //Class实例可以是哪些结构的说明：
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //只要数组的元素类型与维度一样，数组长度不需要一样，就是同一个class。
        System.out.println(c10 == c11);
    }


    //反射之前，对于Person的操作
    @Test
    public void test() {

        Person p1 = new Person("Tom", 12);

        p1.name = "jack";
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：age、showNation()以及私有的构造器

    }

    //反射之后，对于Person的操作
    @Test
    public void test2() {

    }

}
