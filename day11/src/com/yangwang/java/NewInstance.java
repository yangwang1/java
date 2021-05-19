package com.yangwang.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author yangwang
 * @date 2021-05-19-9:22
 */
public class NewInstance {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;

        /*
        newInstance();调用此方法，创建爱你对应的运行时类的对象。内部调用了运行时类的空参构造器。

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public。

        在javaBean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象。
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器。
         */

        Person person = clazz.newInstance();
        System.out.println(person);

    }

    /*
     * 体会反射的动态性
     */
    @Test
    public void test2() {

        for (int i = 0; i < 5; i++) {
            int number = new Random().nextInt(3);
            String classPath = "";
            switch (number){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1 :
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.yangwang.java.Person";
                    break;
            }

            try {
                Object o = newInstance(classPath);
                System.out.println(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object newInstance(String classpath) throws Exception {
        Class clazz = Class.forName(classpath);
        return clazz.newInstance();
    }
}
