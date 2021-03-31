package com.yangwang.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutPutStream的使用
 *
 * 结论：
 * 1.对于文本文件（.txt,.java,.c,.cpp）,使用字符流处理
 * 2.对于非文本文件（.jpg,.mp3,.mp4,.avi,.doc,.ppt,...），使用字节流处理
 * @author yangwang
 * @date 2021-04-01-3:37
 */
public class FileInputOutputStreamTest {

    //非文本文件的复制
    @Test
    public void test5(){
        //1.创建File类的对象，指明读入和写出文件
        File input = new File("测试图片.png");
        File output = new File("测试图片1.png");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //2.创建输入输出流
        try {
            //3.数据的读入和写出操作
            fis = new FileInputStream(input);
            fos = new FileOutputStream(output);
            byte[] bbuf = new byte[1024];
            int len;
            while((len = fis.read(bbuf)) != -1){
                fos.write(bbuf , 0 ,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
