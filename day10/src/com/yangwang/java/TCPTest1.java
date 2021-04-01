package com.yangwang.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上。
 * @author yangwang
 * @date 2021-04-02-1:00
 */
public class TCPTest1 {

    /*
    客户端
     */
    @Test
    public void client() throws IOException {

        //1.创建Socket对象，指明服务器端的ip和端口号
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 8899);
        //2.获取一个输出流，用于输出数据
        OutputStream outputStream = socket.getOutputStream();
        //3.写出数据的操作
        outputStream.write("我是客户端gg".getBytes());
        //4.资源的关闭
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {

        //1.创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(8899);
        //2.调用accept()表示接收来自于客户端的socket
        Socket accept = ss.accept();
        //3.获取输入流
        InputStream inputStream = accept.getInputStream();
        //4.读取输出流中的数据
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[5];
        int len;
        while ((len = inputStream.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        System.out.println("接收到来自： " + accept.getInetAddress().getHostAddress() + " 的消息");

        System.out.println(bos.toString());
        //5.关闭资源
        bos.close();
        inputStream.close();
        accept.close();
        ss.close();
    }
}
