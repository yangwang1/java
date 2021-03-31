package com.yangwang.java.java1.map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author yangwang
 * @date 2021-03-30-18:52
 */
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    //以project为根目录
    public static void main(String[] args) throws Exception{
        Properties pros = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + ", password = " + password);
    }

    //以本module为根目录
    @Test
    public void test() throws Exception{
        Properties pros = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + ", password = " + password);
    }

}
