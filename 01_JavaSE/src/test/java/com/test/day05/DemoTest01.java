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
    public void test01() {
        //	输出0(包含)到100(包含)之间的数, 分别以递增和递减的方式实现；
        for (int i = 0; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 100; i >= 0; i--) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void test02() {
        //输出1到100之间的奇数和偶数；
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println("偶数为:" + i);
            } else if (i % 2 == 1) {
                System.out.println("奇数为:" + i);
            }
        }
    }

    @Test
    public void test03() {
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
    public void test04() {
        //输入一个正整数n，计算1-2+3-4+5-6+…-(n-1)+n的和；
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int number = input.nextInt();
        int n = number;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    @Test
    public void test05() {
        //输出1到1000之间既能被5整除又能被3整除的数，并且每行输出5个。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int number = input.nextInt();
        int i = number;
        int k = 0;
        if (i < 0 || i > 1000) {
            System.out.println("输入的值不合法");
        } else {
            for (int j = 0; j <= i; j++) {
                if (j % 5 == 0 && j % 3 == 0) {
                    System.out.print(j + "\t");
                    k++;
                    /*这里的if一定不能写在上一个if循环的外面，如果你这样写，只要k被5整除，for的循环中的k会一直回车
                     *   因为每 15个数 k+1
                     * */
                    if (k % 5 == 0) {
                        System.out.println();
                    }
                }
            }
        }
    }

    @Test
    public void test06() {
        //求100到999之间的水仙花数。水仙花数的每个位上的数字的3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个100~999之间的数");
        int number = input.nextInt();
        if (number < 100 || number > 999) {
            System.out.println("您输入的值不在范围内");
        } else {
            int i = number;
            for (int j = 100; j <= i; j++) {
                //个位数
                int k = j % 10;
                //十位数
                int o = j / 10 % 10;
                //百位数
                int p = j / 100;
                if (j == k * k * k + o * o * o + p * p * p) {
                    System.out.println("水仙花数为：" + j);
                }
            }
        }
    }

    @Test
    public void test07() {
        //编程找出四位整数abcd中满足下述关系的数，(ab+cd)*(ab+cd)=abcd（例如：(20 + 25) * (20 + 25)= 2025）。
        /*
         * 可以将千位百位和十位个位看作一个整体：
         *       2025 / 100       2025 % 100
         * */
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个1000~9999之间的数");
        int number = input.nextInt();
        if (number < 1000 || number > 9999) {
            System.out.println("您输入的数不符合要求！！！");
        } else {
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
                if ((a + b) * (a + b) == j) {
                    System.out.println("满足要求的数有：" + j);
                }
            }
        }
    }

    @Test
    public void test08() {
        // 输入一个数，判断是奇数还是偶数
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int i = input.nextInt();
        if (i % 2 == 0) {
            System.out.println("您输入的数是偶数");
        } else {
            System.out.println("您输入的数是奇数");
        }
    }

    /**
     * 2.	根据成绩输出对应的等级，使用if多分支和switch语句分别实现。
     * a)	A级   [90,100]
     * b)	B级   [80,90)
     * c)	C级   [70,80)
     * d)	D级   [60,70)
     * e)	E级   [0,60)
     */
    @Test
    public void test09() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的成绩");
        double d = input.nextDouble();
        int score = (int) d / 10;
        switch (score){
            case 10 :
            case 9  :
                System.out.println("您的成绩为A");
                break;
            case 8  :
                System.out.println("您的成绩为B");
                break;
            case 7  :
                System.out.println("您的成绩为C");
                break;
            case 6  :
                System.out.println("您的成绩为D");
                break;
            default:
                System.out.println("您的成绩为E");
                break;
        }
    }

    @Test
    public void test10() {
        // 根据月份，输出对应的季节，并输出至少两个描述该季节的成语和活动
        Scanner input = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = input.nextInt();
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
        }
    }

    @Test
    public void test11(){
        // 判断一个数是否是素数。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int number = input.nextInt();
        boolean flag = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                flag = false;
            }
        }
        if (flag == true){
            System.out.println("这个数是一个素数");
        }else {
            System.out.println("这不是一个素数");
        }
    }

    @Test
    public void test12(){
        // 从键盘输入一个班5个学生的分数，求和并输出。
        Scanner input = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("请输入学生"+i+"的成绩:");
            double score = input.nextDouble();
            sum += score;
        }
        System.out.println("总分为："+sum);
    }

    @Test
    public void test13(){
        // 输入一个正整数，然后把该正整数转化为二进制,使用int来进行输出
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int number = input.nextInt();
        int bit = 0;
        int count = 0;
        while (true){
            if (number == 0){       // 下面的number会一直 / 2 直到等于0后 break 退出循环
                break;
            }else {
                int i = number % 2;
                System.out.println(i);
                number /= 2;
                int pow = (int) Math.pow(10, count);
                count++;
                bit += i * pow;
            }
        }
        System.out.println("使用int接收转二进制的值为:"+bit);
    }


}
