package com.yangwang.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *   InputStreamReader:将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter:将一个字符的输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 * 3.解码：字节、字节数组 --->字符数组、字符串
 *   编码：字符数组、字符串 --->字节、字节数组
 * 4.字符集
 *
 * @author yangwang
 * @date 2021-04-01-4:25
 */
public class InputOutputStreamReader {

    @Test
    public void test() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            FileOutputStream fos = new FileOutputStream("hello_gbk.txt");

            isr = new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(fos,"gbk");

            char[] cbuf = new char[10];
            int len;
            while((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
