package com.test.day02;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;

/**
 * 八大基本数据类型:
 * 整数型  都分符号位
 *      byte     1个字节       -2^7~2^7-1 ==> -128~127
 *      short    2个字节       -2^15~2^15-1  ==> -32768~32767
 *      int      4个字节       -2^31~2^31-1  正负21亿之间的整数
 *      long     8个字节       -2^63~2^63-1
 *  开发中根据数据的大小来选择合适的数据类型
 *      在日常开发中，小数用int，大数用long
 * 浮点型（小数型）     这里的字节大小指的是小数部分的
 *      float       4个字节        这里的float整数部分甚至可以存储100亿
 *      double      8个字节
 * 布尔型
 *      boolean     java规范没有明确占用多少字节
 * 字符型
 *      char    2个字节
 *      包含：char类型只能包含一个字符，多一个少一个都不行
 *      注意：char类型是一个无符号的类型  0~2^16-1  0~65535
 * 字符串：任意多个字符
 *      底层就是一个字符数组
 * "+"号的几个作用
 *       1.用来计算
 *       2.用来拼接
 *       3.当拼接的内容含有字符串时，会将另一个不是字符串的数据先转换为字符串然后再进行拼接
 */
public class Demo02BasicData {
    @Test
    public void test1(){
        //不能直接使用二进制固定常量
        int a = 017;    //八进制
        int b =0x1c;    //16进制
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test02(){
        //整数常量默认为int，即使使用long也不行
//        long a = 10000000000;
        //解决办法在这个固定值常量添加L或者l,建议使用大写的L
        long a = 1666666666666666L;
        System.out.println(a);
    }

    @Test
    public void test03(){
        //3.0000000000000003E-4  3向左边移动4位
        System.out.println(0.0001+0.0002);
    }

    @Test
    public void test04(){
        /**
         * 科学计数法
         */
        double a = 3.14E-3;
        double b = 3.14E3;      //因为本省就是一个浮点数，结果也会带上一个小数点
        double c = 3.14e3;      //建议使用大写的E
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    public void test05(){
        /**
         * 小数类型默认是double类型，当输入的数据是一个float的类型的时候，需要在等号右边进行类型转换，末尾加上F或者f就行，建议大写
         */
        double a = 3.14;
        float b = 3.14f;
        float c = 3.14F;
        System.out.println(c);
    }

    @Test
    public void test06(){
        /**
         * 这里的float整数部分都可以存储超过int类型大小的数据
         */
        float a = 10000000000.14F;
        System.out.println(a);
    }

    @Test
    public void test07(){
        char a1 = '我';
        char a2 = '2';
    }


}
