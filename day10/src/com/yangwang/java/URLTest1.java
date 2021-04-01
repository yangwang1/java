package com.yangwang.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 从tomcat服务端数据下载
 * @author yangwang
 * @date 2021-04-02-2:41
 */
public class URLTest1 {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/examples/测试图片.png");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("测试图片3.png");
        byte[] bbuf = new byte[1024];
        int len;
        while((len = inputStream.read(bbuf)) != -1) {
            fos.write(bbuf, 0, len);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }

}
