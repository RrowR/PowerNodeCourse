package com.test.day06.nightworks;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Test01 {
    @Test
    public void test01() {
        // [难]输入0-9之间的一个数，输出数字构成的1~5位整数的和，如输入2，则计算出2 + 22 + 222 + 2222 + 22222之和。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int i = input.nextInt();
        int result = 0;
        int sum = 0;
        for (int j = 0; j < 5; j++) {
            result *= 10;      // 这里第一次是 0
            result += i;
            sum += result;
            System.out.println(result);
        }
        System.out.println(sum);
    }

    @Test
    public void test02() {
        // 搬砖问题：36块砖，36个人搬，男搬4块，女搬3块，两个小孩搬1块，要求一次搬完，问需要男、女、小孩各多少人？
        // 分析： 男人:0~9  女人：0~12 小孩 ：0~36 一共有 36 人
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 36; k += 2) {
                    if (i + j + k == 36 && 4 * i + 3 * j + k / 2 == 36) {
                        System.out.println("男人:" + i + " 女人:" + j + " 小孩:" + k);
                    }
                }
            }
        }
    }

    @Test
    public void test03() {
        /**
         * 中国古代数学家研究出了计算圆周率最简单的办法: PI=4/1-4/3+4/5-4/7+4/9-4/11+4/13-4/15+4/17...... 这个算式的结果会无限接近于圆周率的值，
         * 我国古代数学家祖冲之计算出，圆周率在3.1415926和3.1415927之间，请编程计算，要想得到这样的结果，他要经过多少次...
         */
        double up = 4;
        double down = 1;
        double sum = 0;
        int flag = 0;
        int count = 0;
//        for (int i = 0; i <100000000; i++) {
        while (true) {
            if (flag % 2 == 0) {
                sum += up / down;
            } else if (flag % 2 == 1) {
                sum -= up / down;
            }
            flag++;
            down += 2;
            if (sum >= 3.1415926 && sum <= 3.1415927){
                break;
            }
            count++;
        }
//        }
        System.out.println(count);      //18660303
//        System.out.println(sum);
    }
}
