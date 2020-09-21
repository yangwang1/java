package com.yangwang.java;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger类：
 * java.math 包的 BigInteger 可以表示不可变的任意精度的整数 。 BigInteger 提供所有 Java 的基本整数操作符的对应物，
 * 并提供 java.lang.Math 的所有相关方法。另外， BigInteger 还提供以下运算：模算术、 GCD 计算、质数测试、素数生成、
 * 位操作以及一些其他操作。
 * <p>
 * 构造器：
 * BigInteger (String val): 根据字符串构建 BigInteger 对象
 * <p>
 * 常用方法
 * 1.public BigInteger abs ()：返回此 BigInteger 的绝对值的 BigInteger 。
 * 2.BigInteger add (BigInteger val) ：返回其值为 (this + val) 的 BigInteger
 * 3.BigInteger subtract (BigInteger val) ：返回其值为 (this val) 的 BigInteger
 * 4.BigInteger multiply (BigInteger val) ：返回其值为 (this * val) 的 BigInteger
 * 5.BigInteger divide (BigInteger val) ：返回其值为 (this / val) 的 BigInteger 。整数相除只保留整数部分 。
 * 6.BigInteger remainder (BigInteger val) ：返回其值为 (this % val) 的 BigInteger 。
 * 7.BigInteger [] divideAndRemainder (BigInteger val)：返回包含 (this / val) 后跟(this % val) 的两个 BigInteger 的数组 。
 * 8.BigInteger pow (int exponent) ：返回其值为 (this exponent ) 的 BigInteger
 * <p>
 * BigDecimal类：
 * 一般的 Float 类和 Double 类可以用来做科学计算或工程计算，但在 商业计算中，要求数字精度比较高，故用到 java.math.BigDecimal 类 。
 * BigDecimal 类支持不可变的、任意精度的有符号十进制定点数
 * <p>
 * 构造器：
 * public BigDecimal(double val)
 * public BigDecimal (String val)
 * <p>
 * 常用方法:
 * public BigDecimal add (BigDecimal)
 * public BigDecimal subtract (BigDecimal)
 * public BigDecimal multiply (BigDecimal)
 * public BigDecimal divide (BigDecimal divisor, int scale, int roundingMode)
 *
 * @author yangwang
 * @date 2020-08-27-14:02
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("-3289436124931684916948619841368461");
        System.out.println(b);
        BigInteger c = b.abs();
        System.out.println(c);

        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
    }
}
