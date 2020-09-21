package com.yangwang.java;

import org.junit.Test;

import java.lang.annotation.*;
import java.util.ArrayList;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * 一、如何自定义注解：参照@SuppressWarnings定义
 * 1.注解声明为:@interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员的默认值，使用default定义
 * 4.如果自定义注解没有成员，表明是一个标识作用。
 * <p>
 * 如果注解有成员，在使用注解时，需要指明成员的值。
 * 自定义注解必须配上注解的信息处理流程（使用反射）才有意义。
 * 自定义注解通常都会指明两个元注解:Retention、Target
 * <p>
 * 2、jdk提供的四种元注解
 * 元注解：对现有的注解进行解释说明的注解
 * Retention：指定所修饰的Annotation的生命周期：SOURCE/CLASS(默认行为)/RUNTIME 只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 * Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 * <p>
 * 下面两个用的较少
 * Documented:表示所修饰的注解在被javadoc解析时，保留下来
 * Inherited：表示所修饰的注解具有继承性，父类标上注解，子类默认含有该注解
 * <p>
 * 3.通过反射获取注解信息
 *
 * 4.jdk8中注解的新特性：可重复注解，类型注解
 * 4.1 可重复注解：1.在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *               2.MyAnnotation的Target、Retention、Inherited等和MyAnnotations相同。
 * 4.2 类型注解：
 * ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中 如 泛型声明 。
 * ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中 。
 *
 * @author yangwang
 * @date 2020-09-21-23:19
 */
public class AnnotationTest {
    public static void main(String[] args) {
        @MyAnnotation("hi")
        @SuppressWarnings("unusd")
        int c = 0;
        System.out.println(c);
    }

    @Test
    public void testAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}

@Inherited
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default {"hello", "hi"};
}

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations {
    MyAnnotation[] value();
}

//重复注解
//jdk1.8之前
//@MyAnnotations({@MyAnnotation("hi"),@MyAnnotation("hello")})
//jdk1.8之后
@MyAnnotation("hi")
@MyAnnotation("hello")
class Person {

}

class Student extends Person {

}

//这个泛型的注解是由Target.TYPE_PARAMETER许可的
class Generic<@MyAnnotation T> {

    //下面三种情况的注解是由Target.TYPE_USE许可的
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }

}
