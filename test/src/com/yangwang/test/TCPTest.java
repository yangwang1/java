package com.yangwang.test;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * 根据以上知识点实现一个事件统计服务，场景如下：
 * 程序分为服务端与客户端，其中服务端以任一网络IO模型（推荐：epoll）对客户端进行管理。
 * 1.客户端：
 * 1.产生随机事件，其中包括：客户端id，事件发生时间，事件描述，例如：1001 “2021-05-10 14:21:29” “something happens"。
 * 2.将产生的事件推送给服务端；
 * 3.一旦与服务端交互失败，则立即退出。
 * 2.服务端：
 * 1.管理客户端连接与事件推送；
 * 2.将接收到的事件以一定的格式存文件（或直接打印至标准输出）；
 * 3.内部维护当前活跃的所有客户端id，当有客户端异常时（断开或其他原因），将其id从维护信息中移除；
 * 4.重载输出运算符，当维护信息变化时，以输出运算符输出其内部维护的客户端信息（格式不限），例如：
 * ID: 01, sockFd: 5
 * ID: 02, sockFd: 6
 * ...
 * 5.每接收10条事件推送，输出当前客户端活跃排名列表（每个ID维护一个贡献值，与其推送的消息总数正相关）。
 * 当权重相等时，以ID从小到大的顺序排列。
 * 提示：
 * 1.将客户端ID与其权重作为整体进行维护和处理，即定义相关类型或结构；
 * 2.重载服务类的输出运算符，使得在对其进行输出调用的时候，输出内部的维护信息；
 * 3.在进行比较时，使用容器的排序算法（自定义排序规则：重载比较运算符）
 * 4.自定义传输协议（即从tcp字节流传输和解析事件的各个字段）
 *
 * @author yangwang
 * @date 2021-05-16-19:58
 */
public class TCPTest {

    // * 1.客户端：
    // * 1.产生随机事件，其中包括：客户端id，事件发生时间，事件描述，例如：1001 “2021-05-10 14:21:29” “something happens"。
    // * 2.将产生的事件推送给服务端；
    // * 3.一旦与服务端交互失败，则立即退出。
    @Test
    public void client() throws IOException {

        //获取本机ip作为id
        String id = InetAddress.getLocalHost().getHostAddress();
        System.out.println(id);
        //获取当前时间
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date=sDateFormat.format(new Date());
        System.out.println(date);

        //随机事件产生逻辑,省略啦

        //组装
        Event event = new Event(id, date, "something happens");

        //1.创建Socket对象，指明服务器端的ip和端口号
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 8899);

        //2.获取一个输出流，用于输出数据
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        //3.写出数据的操作
        oos.writeObject(event);

        //4.资源的关闭
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException, ClassNotFoundException {
        //1.创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(8899);
        Map<String, Manage> map = new HashMap<>();
        int i = 0;

        while (true) {
            i++;
            //2.调用accept()表示接收来自于客户端的socket
            Socket accept = ss.accept();
            //3.获取输入流
            InputStream inputStream = accept.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            //4.读取输出流中的数据
            Object o = ois.readObject();
            Event event = (Event) o;
            System.out.println(event);

            String id = event.getId();
            Manage manage = map.get(id);
            if (manage == null) {
                ArrayList<Event> events = new ArrayList<>();
                events.add(event);
                map.put(id, new Manage(id, events));
                System.out.println(events);
            } else {
                ArrayList<Event> events = manage.getEvents();
                events.add(event);
                System.out.println(events);
            }

            if(i == 10){
                Collection<Manage> values = map.values();
                for (Manage m: values){
                    System.out.println(m.getId()+ ": " + m.getTimes());
                }
                i = 0;
            }

            inputStream.close();
            accept.close();
        }

        //5.关闭资源
//        ss.close();
    }

}
