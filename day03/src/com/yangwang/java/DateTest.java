package com.yangwang.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author yangwang
 * @date 2020-08-27-11:07
 */
public class DateTest {
    public static void main(String[] args) {
        //Date类
        Date d = new Date();
        System.out.println(d);

        System.out.println(System.currentTimeMillis());
//        System.out.println(d.getTime());
//        System.out.println(d.toString());

        Date d1 = new Date(d.getTime());
        System.out.println(d1.getTime());
        System.out.println(d1.toString());

        //Date格式化
        SimpleDateFormat formater = new SimpleDateFormat();
        System.out.println(formater.format(d)); //默认的格式

        SimpleDateFormat formater2 = new SimpleDateFormat("yyyy MM dd EEE hh:mm:ss");
        System.out.println(formater2.format(d)); //自定义的格式

        try {
            //实例化一个指定的时间对象
            Date d2 = formater2.parse("2020 08 27 星期四 11:23:13");
            System.out.println(d2.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //日历类
        Calendar calendar = Calendar.getInstance();
        //从Calendar对象获取一个Date对象
        //Date d3 = calendar.getTime();
        //使用给定的 Date 设置此 Calendar 的时间
        Date d3 = new Date(234234235235L);
        calendar.setTime(d3);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        System.out.println("当前时间日设置为 8 后 时间是 :" + calendar.getTime());
        calendar.add(Calendar.HOUR, 2);
        System.out.println("当前时间加 2 小时后 时间是 :" + calendar.getTime());
        calendar.add(Calendar.MONTH, -2);
        System.out.println("当前日期减 2 个月后 时间是 :" + calendar.getTime());
    }
}
