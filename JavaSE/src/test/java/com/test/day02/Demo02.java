package com.test.day02;

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
 * 浮点型（小数型）
 *      float       4个字节
 *      double      8个字节
 * 布尔型
 *      boolean     java规范没有明确占用多少字节
 * 字符型
 *      char    2个字节
 *
 */
public class Demo02 {
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


}
