package com.yangwang.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  实现TCP的网络编程
 *  例子3：客户端发送文件给服务端，服务端将文件保存在本地。并返回"发送成功"给客户端。
 *        并关闭相应的连接
 * @author yangwang
 * @date 2021-04-02-1:34
 */
public class TCPTest3 {

    @Test
    public void client() throws IOException {

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 9090);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("测试图片.png");

        byte[] b = new byte[1024];
        int len;
        while((len = fis.read(b)) != -1){
            outputStream.write(b, 0, len);
        }

        //关闭数据流的输出
        socket.shutdownOutput();

        System.out.println("客户端发送成功");

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bbuf = new byte[1024];
        int len1;
        while((len1 = inputStream.read(bbuf)) != -1) {
            bos.write(bbuf, 0, len1);
        }

        System.out.println(bos.toString());

        fis.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(9090);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream("测试图片2.png");

        byte[] b = new byte[1024];
        int len;
        while((len = is.read(b)) != -1) {
            fos.write(b, 0, len);
        }

        System.out.println("服务器接收成功");

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("接收成功,非常大".getBytes());

        outputStream.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
