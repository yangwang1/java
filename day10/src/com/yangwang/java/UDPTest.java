package com.yangwang.java;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 * @author yangwang
 * @date 2021-04-02-2:11
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP数据";
        byte[] data = str.getBytes();
        InetAddress inetAddress = InetAddress.getLocalHost();

        DatagramPacket packet = new DatagramPacket(data, 0, data.length,inetAddress,9999);

        socket.send(packet);
        socket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] data = new byte[100];
        DatagramPacket packet = new DatagramPacket(data, 0, data.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, data.length));
        socket.close();
    }
}
