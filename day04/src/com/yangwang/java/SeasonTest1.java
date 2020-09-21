package com.yangwang.java;

/**
 * 方式二：jdk，可以使用enum关键字定义枚举类
 *
 * @author yangwang
 * @date 2020-09-15-23:51
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getSuperclass());
    }
}

interface Info {
    void show();
}

//自定义枚举类
enum Season1 implements Info {
    //3.提供当前枚举类的多个对象：public static final的
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };

    //1.声明season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
