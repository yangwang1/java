package com.yangwang.java;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL：统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *   http://localhost:8080/examples/测试图片.png?username=Tom
 *   协议    主机名     端口号 资源地址             参数列表
 *
 * @author yangwang
 * @date 2021-04-02-2:35
 */
public class URLTest {

    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/测试图片.png?username=Tom");
        System.out.println(url.getProtocol());  //获取该URL的协议名
        System.out.println(url.getProtocol());  //获取该URL的主机名
        System.out.println(url.getProtocol());  //获取该URL的端口号
        System.out.println(url.getProtocol());  //获取该URL的文件路径
        System.out.println(url.getProtocol());  //获取该URL的文件名
        System.out.println(url.getProtocol());  //获取该URL的查询名


    }

}
