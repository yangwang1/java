package com.yangwang.java2;

import com.yangwang.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 * @author yangwang
 * @date 2021-05-19-10:49
 */
public class MethodTest {

    @Test
    public void test1(){

        Class clazz = Person.class;

        //getMethods();获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m: methods) {
            System.out.println(m);
        }

        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。不包括父类中声明的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods) {
            System.out.println(m);
        }

    }

    /*
    @Xxxx
    权限修饰符 返回值类型 方法名（参数类型1 形参名，...）throws XxxException{}
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method m : declaredMethods) {
            //1.获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.println(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.println(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.println(m.getName());
            System.out.println("(");

            //5.形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for (int i = 0; i < parameterTypes.length; i++) {

                    if(i == parameterTypes.length - 1){
                        System.out.println(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }

                    System.out.println(parameterTypes[i].getName() + " args_" + i + ",");
                }


            }
            System.out.println(")");

            //6.抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.println("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length - 1){
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.println(exceptionTypes[i].getName() + "," );
                }

            }

            System.out.println();
        }
        
    }
}
