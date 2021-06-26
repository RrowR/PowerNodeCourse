package com.test.day05;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * 1、	输出0(包含)到100(包含)之间的数, 分别以递增和递减的方式实现；
 * 2、	输出1到100之间的奇数和偶数；
 * 3、	输入一个正整数n，计算1+2+3+…+n的和；
 * 4、	输入一个正整数n，计算1-2+3-4+5-6+…-(n-1)+n的和；
 * 5、	输出1到1000之间既能被5整除又能被3整除的数，并且每行输出5个。
 */
public class DemoTest01 {
    @Test
    public void test01(){
        //	输出0(包含)到100(包含)之间的数, 分别以递增和递减的方式实现；
        for (int i = 0; i <= 100; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 100; i >= 0 ; i--) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void test02(){
        //输出1到100之间的奇数和偶数；
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println("偶数为:"+i);
            }else if (i % 2 == 1){
                System.out.println("奇数为:"+i);
            }
        }
    }

    @Test
    public void test03(){
        //输入一个正整数n，计算1+2+3+…+n的和；
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int number = input.nextInt();
        int n = number;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void test04(){
        //输入一个正整数n，计算1-2+3-4+5-6+…-(n-1)+n的和；
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int number = input.nextInt();
        int n = number;
        int sum = 0;
        for (int i = 0; i <= n ; i++) {
            if (i % 2 == 0){
                sum -= i;
            }else {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    @Test
    public void test05(){
        //输出1到1000之间既能被5整除又能被3整除的数，并且每行输出5个。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int number = input.nextInt();
        int i = number;
        int k = 0;
        if (i < 0 || i > 1000){
            System.out.println("输入的值不合法");
        }else {
            for (int j = 0; j <= i; j++) {
                if (j % 5 == 0 && j % 3 == 0){
                    System.out.print(j+"\t");
                    k++;
                    /*这里的if一定不能写在上一个if循环的外面，如果你这样写，只要k被5整除，for的循环中的k会一直回车
                    *   因为每 15个数 k+1
                    * */
                    if (k % 5 == 0){
                        System.out.println();
                    }
                }
            }
        }
    }
}
