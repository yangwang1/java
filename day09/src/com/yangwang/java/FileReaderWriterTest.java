package com.yangwang.java;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：字节流、处理流
 *
 * 二、流的体系结构
 * 抽象基类               节点流(或文件流)             缓冲流（处理流的一种）
 * InputStream           FileInputStream          BufferedInputStream
 * OutputStream          FileOutputStream         BufferedOutputStream
 * Reader                FileReader               BufferedReader
 * Writer                FileWriter               BufferedWriter
 *
 * @author yangwang
 * @date 2021-03-31-22:26
 */
public class FileReaderWriterTest {

    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台
    说明点：
    1.read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2.异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3.读入的文件一定要存在，否则就会报FileNotFoundException
     */
    @Test
    public void test(){
        //1.实例化File类的对象，指明要操作的文件
        File file = new File("hello.txt");
        //2.提供具体的流
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //read(char[]):返回读入字符数，内容存在char[]中
    @Test
    public void test2(){
        //1.实例化File类的对象，指明要操作的文件
        File file = new File("hello.txt");
        //2.提供具体的流
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            //3.数据的读入
            char[] cbuf= new char[5];
            //read(char[]):返回读入字符数，内容存在char[]中
            int len;
            while ((len = fr.read(cbuf) )!= -1) {
                //方式一：
//                for(int i = 0; i < len; i++){
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里

    说明：
    1.输出操作，对应的File可以不存在的。并不会报异常
    2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
      File对应的硬盘中的文件如果存在：
          如果流使用的构造器是：FileWriter(file, false) / FileWriter(file):对原有的文件覆盖
          如果流使用的构造器是：FileWriter(file, true)：对原有的文件不覆盖，在内容上进行追加
     */
    @Test
    public void test3(){
        File file = new File("hello1.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("I am tom \n");
            fileWriter.write("I have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter !=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //文件读入写出
    @Test
    public void test4(){
        //1.创建File类的对象，指明读入和写出文件
        File input = new File("hello.txt");
        File output = new File("hello2.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        //2.创建输入输出流
        try {
            //3.数据的读入和写出操作
            fileReader = new FileReader(input);
            fileWriter = new FileWriter(output);
            char[] cbuf = new char[5];
            int len;
            while((len = fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf , 0 ,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
