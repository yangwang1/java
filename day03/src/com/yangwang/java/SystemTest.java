package com.yangwang.java;

/**
 * 系统类
 * 成员方法:
 * 1.native long currentTimeMillis()
 * 该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和 GMT 时间 格林威治时间 )1970 年 1 月 1 号 0 时 0 分 0秒所差的毫秒数。
 * 2.void exit(int status)
 * 该方法的作用是退出程序。其中 status 的值为 0 代表正常退出，非零代表异常退出。 使用该方法可以在图形界面编程中实现程序的退出功能 等 。
 * 3.void gc()
 * 该方法的作用是请求系统进行垃圾回收。至于系统是否立刻回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况。
 * 4.String getProperty(String key)
 * 该方法的作用是获得系统中属性名为 key 的属性对应的值。
 *
 * @author yangwang
 * @date 2020-08-27-12:53
 */
public class SystemTest {
    public static void main(String[] args) {
        String javaVersion = System. getProperty("java.version");  //java运行时环境版本
        System.out.println("java的version：" + javaVersion);

        String javaHome = System. getProperty("java.home"); //java安装目录
        System.out.println("java的home：" + javaHome);

        String osName = System. getProperty("os.name");  //操作系统的名称
        System.out.println("os的name：" + osName);

        String osVersion = System. getProperty("os.version"); //操作系统的版本
        System.out.println("os的version：" + osVersion);

        String userName = System. getProperty("user.name"); //用户的账户名称
        System.out.println("user的name：" + userName);

        String userHome = System. getProperty("user.home"); //用户的主目录
        System.out.println("user的home：" + userHome);

        String userDir = System. getProperty("user.dir"); //用户的当前工作目录
        System.out.println("user的dir：" + userDir);

    }
}
