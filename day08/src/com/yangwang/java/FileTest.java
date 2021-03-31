package com.yangwang.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 * 1.File类的一个对象，代表一个文件或一个文件目录(速成：文件夹)
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关羽文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *   并未涉及到写入或读取文件内容的操作。如果需要读写或写入文件内容，必须使用IO流来完成。
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点"
 * @author yangwang
 * @date 2021-03-31-18:33
 */
public class FileTest {

    /*
     1.如何创建File类的实例
      File(String filePath)
      File(String parentPath, String childPath)
      File(File parentFile, String childPath)

     2.相对路径：相较于某个路径下，指明的路径。
       绝对路径：包含盘符在内的文件或文件目录的路径
       File.pathSeparator: ;
       File.separator: \


     3.路径分隔符
       windows:\\
       unix:/
     */

    @Test
    public void test(){

        //构造器1
        File file1 = new File("hello.txt"); //相当于当前module
        File file2 = new File("D:\\ideaWorkspace\\Project01\\day08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2:
        File file3 = new File("D:\\ideaWorkspace", "Project01");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);

        //通用常量
        File file5 = new File("D:"+File.separator+"ideaWorkspace");
        System.out.println(file5);
        System.out.println(File.pathSeparator); // ;
        System.out.println(File.separator); // /

    }

    /*
    public String getAbsolutePath():获取绝对路径
    public String getPath():获取路径
    public String getName():获取名称
    public String getParent():获取上层文件目录路径。若无，返回null
    public long length():获取文件长度(即:字节数)。不能获取目录的长度
    public long lastModified():获取最后一次的修改时间，毫秒值

    public String[] list():获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组

    public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：file1.renameTo(file2)为例:
        要想保证返回true,需要file1在硬盘中是餐在的，且file2不能再硬盘中年那个存在。
        相当于文件移动，文件会移动到新的地址

     */
    @Test
    public void test2(){
        File file = new File("hello.txt");
        //public String getAbsolutePath():获取绝对路径
        System.out.println(file.getAbsolutePath());

        //public String getPath():获取路径
        System.out.println(file.getPath());

        //public String getName():获取名称
        System.out.println(file.getName());

        //public String getParent():获取上层文件目录路径。若无，返回null
        System.out.println(file.getParent());

        //public long length():获取文件长度(即:字节数)。不能获取目录的长度
        System.out.println(file.length());

        //public long lastModified():获取最后一次的修改时间，毫秒值
        System.out.println(new Date(file.lastModified()));

    }

    @Test
    public void test3() {
        File file = new File("D:\\ideaWorkspace\\Project01");
        //public String[] list():获取指定目录下的所有文件或者文件目录的名称数组
        String[] list = file.list();
        for (String f: list) {
            System.out.println(f);
        }
        //public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file.listFiles();
        for (File f2 : files){
            System.out.println(f2);
        }
    }

    @Test
    public void test4() {
    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：file1.renameTo(file2)为例:
        要想保证返回true,需要file1在硬盘中是餐在的，且file2不能再硬盘中年那个存在。
        相当于文件移动，文件会移动到新的地址
     */
        File file = new File("renameTo.txt");
        File file2 = new File("renameTo2.txt");
        boolean renameTo = file.renameTo(file2);
        System.out.println(renameTo);
    }

    /*
    public boolean isDirectory();判断是否是文件目录
    public boolean isFile():判断是否是文件
    public boolean exists():判断是否存在
    public boolean canRead():判断是否可读
    public boolean canWrite():判断是都可写
    public boolean isHidden():判断是否隐藏
     */
    @Test
    public void test5(){
        File file = new File("D:\\ideaWorkspace\\Project01");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }

    /*
     创建硬盘中对应的文件或文件目录
     public boolean createNewFile():创建文件。若文件存在,则不创建，返回false
     public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件的上层目录不存在，也不创建
     public boolean mkdirs():创建文件目录。如果上层文件目录不存在，一并创建

     删除磁盘中的文件或文件目录
     public boolean delete()：删除文件或者文件夹
     删除注意事项：
     Java中的删除不走回收站。
     */
    @Test
    public void test6() throws IOException {
        File file = new File("create.txt");
        if (!file.exists()){
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
            System.out.println("创建成功");
        } else {
            file.delete();
            System.out.println("删除成功");
        }

    }

    @Test
    public void test7() throws IOException{
        File file2 = new File("D:\\ideaWorkspace\\Project01\\day08\\mkdir");
        if (!file2.exists()){
            boolean mkdir = file2.mkdir();
            System.out.println(mkdir);
            System.out.println("创建成功");
        } else {
            file2.delete();
            System.out.println("删除成功");
        }
    }

}
