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

    @Test
    public void test06(){
        //求100到999之间的水仙花数。水仙花数的每个位上的数字的3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个100~999之间的数");
        int number = input.nextInt();
        if (number < 100 || number > 999){
            System.out.println("您输入的值不在范围内");
        }else {
            int i = number;
            for (int j = 100; j <= i; j++) {
                //个位数
                int k = j % 10;
                //十位数
                int o = j / 10 % 10;
                //百位数
                int p = j / 100;
                if (j == k*k*k + o*o*o + p*p*p){
                    System.out.println("水仙花数为："+j);
                }
            }
        }
    }

    @Test
    public void test07(){
        //编程找出四位整数abcd中满足下述关系的数，(ab+cd)*(ab+cd)=abcd（例如：(20 + 25) * (20 + 25)= 2025）。
        /*
        * 可以将千位百位和十位个位看作一个整体：
        *       2025 / 100       2025 % 100
        * */
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个1000~9999之间的数");
        int number = input.nextInt();
        if (number < 1000 || number > 9999){
            System.out.println("您输入的数不符合要求！！！");
        }else {
            /*int i = number;
            for (int j = 1000; j < i; j++) {
                //求个位数
                int b = j % 10;
                //求十位数
                int c = j / 10 % 10;
                //求百位数
                int d = j / 100 % 10;
                //求千位数
                int e = j / 1000 % 10;
                if (j == ((e*10 + d)+(c*10 + b))*((e*10 + d)+(c*10 + b))){
                    System.out.println("满足要求的数有："+j);
                }
            }*/
            int i = number;
            for (int j = 1000; j < i; j++) {
            // 求千位百位
            int a = j / 100;
            // 求百位十位
            int b = j % 100;
            if ((a + b)*(a + b) == j){
            System.out.println("满足要求的数有："+j);
        }
    }
}
    }

@Test
public void test08(){
        // 输入一个数，判断是奇数还是偶数
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int i = input.nextInt();
        if (i % 2 == 0){
            System.out.println("您输入的数是偶数");
        }else {
            System.out.println("您输入的数是奇数");
        }
    }
}
