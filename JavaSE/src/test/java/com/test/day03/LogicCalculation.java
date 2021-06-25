package com.test.day03;

import org.junit.jupiter.api.Test;

/**
 * 逻辑运算符
 * & | ^ && ||
 *  面试：&和&& |和||的区别
 *  结果是一样的，但是&&和||的效率高
 */
public class LogicCalculation {
    @Test
    public void yihuo(){
        /**
         * ^ 异或运算
         */
        System.out.println(true^true);
        System.out.println(true^false);
        System.out.println(false^true);
        System.out.println(false^false);
    }

    @Test
    public void Or02(){
        /**
         * 或运算符|
         */
        System.out.println(true|false);
        System.out.println(false|true);
        System.out.println(true|true);
        System.out.println(false|false);
    }

    @Test
    public void And01(){
        /**
         * 与运算符(二元运算符)
         */
        System.out.println(true&true);
        System.out.println(false&true);
        System.out.println(true&false);
        System.out.println(false&false);
    }
}
