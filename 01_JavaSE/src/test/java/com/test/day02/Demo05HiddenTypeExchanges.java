package com.test.day02;


import org.junit.Test;

public class Demo05HiddenTypeExchanges {

    @Test
    public void test05(){
        int a = 10;
        float b = 1.1F;
        float sum = a + b;
        System.out.println(sum);
    }

    @Test
    public void test04(){
        /**
         * 这里也是一个隐士数据类型的转换
         */
        float sum = 10 + 1.1F;
        System.out.println(sum);
    }

    @Test
    public void test03(){
        /**
         * 这里也是一个特殊的列子，当类型是一个int的类型，当我们 赋值 给byte类型的时候，必须将他设置成常量(final修饰)，并且值不能超过byte的大小
         */
        final int a = 10;
        byte b = a;
        System.out.println(b);
    }

    @Test
    public void demo02(){
        /**
         * 这里是一个特殊的例子(隐式int类型转换成byte类型),当向下转型的数据不超过byte的时候，就可以进行转换
         */
        byte a = 10;
        System.out.println(a);
    }

    @Test
    public void demo01(){
        /**
         * 由于java是一个强类型语言，在进行运算的时候，数据类型会保持一致
         *  所以这里的a会转换成float类型
         */
        int a =  10;
        float b = 1.1F;
        float c = a + b;
        System.out.println(c);
    }
}
