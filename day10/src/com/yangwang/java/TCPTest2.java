package com.yangwang.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *  实现TCP的网络编程
 *  例子2：客户端发送文件给服务端，服务端将文件保存在本地。
 * @author yangwang
 * @date 2021-04-02-1:34
 */
public class TCPTest2 {

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

        System.out.println("客户端发送成功");
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

        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
