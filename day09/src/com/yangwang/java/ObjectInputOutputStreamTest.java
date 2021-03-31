package com.yangwang.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * @author yangwang
 * @date 2021-04-01-6:20
 */
public class ObjectInputOutputStreamTest {

    /*
    1.序列化：将内存中的对象写入磁盘或通过网络传输出去
     */
    @Test
    public void test() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("我有一个梦想"));
        oos.flush();
        oos.writeObject(new Person("tom", 22));
        oos.flush();
        oos.close();
    }

    /*
    2.反序列化:将磁盘文件中的对象或网络获取的流读入到内存中
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
        Object o = ois.readObject();
        Person p = (Person)ois.readObject();
        System.out.println(o);
        System.out.println(p);
    }
}
