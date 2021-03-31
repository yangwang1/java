package com.yangwang.java;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承与java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认从头覆盖）
 * 4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 * @author yangwang
 * @date 2021-04-01-6:54
 */
public class RandomAccessFileTest {

    /*
      new RandomAccessFile(new File("hello.txt"),"r");
      r：只读
      rw：读写
      rwd：读写;同步文件内容的更新
      rws：读写；同步文件内容和元数据的更新
     */
    @Test
    public void test() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("hello.txt"),"r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("hello4.txt"),"rw");
        byte[] cbuf = new byte[10];
        int len;
        while((len = raf.read(cbuf)) != -1){
            raf2.write(cbuf,0,len);
        }

        raf.close();
        raf2.close();
    }

    @Test
    public void test2() throws IOException{
        RandomAccessFile raf = new RandomAccessFile(new File("hello4.txt"),"rw");
        raf.write("xyz".getBytes());
        raf.close();
    }

    /*
     使用RandomAccessFile达到插入效果
     */
    @Test
    public void test3() throws IOException{
        RandomAccessFile raf = new RandomAccessFile(new File("hello4.txt"),"rw");
        raf.seek(3);//指针移到3
        StringBuffer s = new StringBuffer((int) new File("hello4.txt").length());
        byte[] b = new byte[10];
        int len;
        while ((len = raf.read(b)) != -1) {
            s.append(new String(b, 0, len));
        }
        raf.seek(3); //指针移到3
        raf.write("xyz".getBytes());
        raf.write(s.toString().getBytes());

        raf.close();
    }

}
