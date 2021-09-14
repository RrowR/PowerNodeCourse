package day06;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
//        method01();
//        method02();
//        method03();
        method04();
    }

    private static void method04() {
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

    private static void method03() {
        // 输入一个正整数，然后把该正整数转化为二进制
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int number = input.nextInt();
        String str = "";
        while (true){
            if (number == 0){
                break;
            }else {
                int i = number % 2;
                System.out.println(i);
                number /= 2;
                // 注意 int 类型要写在左边才是倒序
                str = i + str;
            }
        }
        System.out.println(str);
    }

    // [难]输入一个任意整数，判断它是否为质数，如果是质数就输出“是质数”，否则输出‘不是质数’。质数：除了1和它本身之外,不能被其他数整除的正整数称质数。(质数也称之为素数)
    private static void method02() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int number = input.nextInt();
        boolean flag = true;
        for (int i = 2;i < number;i++){
            /*  这里是错的，这里是要么是质数，要么就不是质数，而在除的过程中会打印很多次语句（不是质数，是质数）
            if (number % i == 0){
                System.out.println("您输入的数"+number+"不是一个质数");
            }else {
                System.out.println("您输入的数"+number+"是质数");
            }*/
            // 这里当i判断到不是一个质数的时候，将flag改为false，然后使用break跳出整个循环
            if (number % i == 0){
                System.out.println("您输入的数"+number+"不是一个质数");
                flag = false;
                break;      // break 会跳出整个for循环不会再执行
            }
        }
        if (flag == true){
            System.out.println("您输入的数"+number+"是一个质数");
        }

    }

    // 韩信点兵
    private static void method01() {
        int i = 1;
        while (true){
            if (i % 3 == 2 && i % 5 == 3 && i % 7 == 4){
                System.out.println("人数最少为："+i+"人");
                break;
            }
            i++;
        }
    }


}
