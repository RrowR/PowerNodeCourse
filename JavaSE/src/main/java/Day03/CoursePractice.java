package Day03;

import java.util.Scanner;

public class CoursePractice {
    public static void main(String[] args) {
//        method01();
        method02();

    }

    private static void method02() {
        /**
         * 判断一个数是否在4（不包含）~6（包含）之外；
         *  首先需要仔细分析：结果为[4,6)之外
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        double d = scanner.nextDouble();
        if (d<=4 || d>6){
            System.out.println(d+"您输入的数在[4,6)之外");
        }else {
            System.out.println(d+"您输入的数在[4,6)之内");
        }
    }

    /**
     *  判断一个数是否在4（包含）~6（不包含）之间
     *
     */
    private static void method01() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        double d = scanner.nextDouble();
        if (d>=4 && d<6){
            System.out.println(d+"您输入的数>=4且<6");
        }else {
            System.out.println(d+"您输入的这个数<4且>=6");
        }
    }
}
