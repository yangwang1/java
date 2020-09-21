package com.yangwang.java;

/**
 * @author yangwang
 * @date 2020-08-27-9:58
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public static void main(String[] args) {
        StringTest ts = new StringTest();
        ts.change(ts.str, ts.ch);  //str = good  ch=best
        System.out.println(ts.str + " and ");  //test ok and
        System.out.println(ts.ch);  //best

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);

        //StringBuffer sb1 = new StringBuffer(str); //空指针
        //System.out.println(sb1);

        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");
        System.out.println(a.equals(b)); //true
        System.out.println(a==b); //true
        System.out.println(c.equals(d)); //true
        System.out.println(c==d); //false
        System.out.println(a.equals(c)); //true
        System.out.println(a==c); //false
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
}
