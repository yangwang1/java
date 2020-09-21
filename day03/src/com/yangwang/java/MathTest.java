package com.yangwang.java;

/**
 * Math类
 * java.lang.Math
 * 提供了一系列静态方法用于 科学 计算。其 方法的参数和返回值类型一般为 double 型。
 * abs 绝对值
 * acos,asin,atan,cos,sin,tan三角函数
 * sqrt 平方根
 * pow(double a,doble b) a的b次幂
 * log 自然对数
 * exp e为底指数
 * max(double a,double b)
 * min(double a,double b)
 * random()返回 0.0 到 1.0 的随机数
 * long round(double a) double型数据a转换为long型（四舍五入）
 * toDegrees(double angrad) 弧度转角度
 * toRadians(double angdeg) 角度转弧度
 *
 * @author yangwang
 * @date 2020-08-27-13:44
 */
public class MathTest {
    public static void main(String[] args) {
        double i = Math.abs(-31.8);
        System.out.println(i);
    }
}
