package com.yangwang.java;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @author yangwang
 * @date 2021-04-01-5:06
 */
public class OtherStreamTest {
    /*
    1.1
    System.in:标准的输入流，默认从键盘输入
    System.out:标准的输出流，默认从控制台输出
    1.2
    System类的setIn(InputStream is) /setOut(PrintStream ps)方式重新指定输入和输出的流
    1.3练习：
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
    直至当输入“e”或者“exit”时，退出程序。

    方法一：使用Scanner实现，调用next()返回一个字符串
    方法二：使用System.in实现。System.in ---> 转换流 --->BufferedReader的readLine()方法
     */

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bw = new BufferedReader(isr);
        try{
            while(true){
                System.out.println("请输出数据");
                String data = bw.readLine();
                if("e".equals(data)||"exit".equals(data)){
                    System.out.println("程序结束");
                    break;
                }

                System.out.println(data.toUpperCase());
            }

        } catch(IOException e){
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    3.数据流
    3.1.DataInputStream和DataOutputStream
    3.2 作用：用于读取或写出基本数据类型的变量或字符串

     */
    @Test
    public void test() throws IOException {
        FileOutputStream fos = new FileOutputStream("data.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("汤姆");
        dos.flush();
        dos.writeInt(22);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }

    /*
    将文件中存储的基本数据类型变量和字符串读取到内存中年，保存在变量中
    注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
     */
    @Test
    public void test2() throws IOException {
        FileInputStream fis = new FileInputStream("data.txt");
        DataInputStream dis = new DataInputStream(fis);
        String s = dis.readUTF();
        int i = dis.readInt();
        boolean b = dis.readBoolean();

        System.out.println(s);
        System.out.println(i);
        System.out.println(b);
    }
}
