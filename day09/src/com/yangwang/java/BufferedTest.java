package com.yangwang.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 *
 * 2.作用：提升流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流，就是“套接”在已有的流的基础上。
 * @author yangwang
 * @date 2021-04-01-3:42
 */
public class BufferedTest {

    //非文本文件复制
    @Test
    public void test() {
        File in = new File("测试图片.png");
        File out = new File("测试图片2.png");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(in);
            FileOutputStream fos = new FileOutputStream(out);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] bbuf = new byte[1024];
            int len;
            while((len = bis.read(bbuf)) != -1) {
                bos.write(bbuf, 0 ,len);
                //bos.flush(); //刷新缓冲区，直接写出
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //文本文件复制
    @Test
    public void test2(){

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            FileReader fr = new FileReader("hello.txt");
            FileWriter fw = new FileWriter("hello3.txt");

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //方式一
//            char[] cbuf = new char[10];
//            int len;
//            while((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf, 0, len);
//            }
            //方式二：
            String data;
            while((data = br.readLine())!=null){
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
