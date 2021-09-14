package day04;

import java.util.Scanner;

/**
 * 判断是否是闰年:
 *      四年一闰，百年不闰，四百年再闰
 *      主要运用了逻辑运算符来判断两个关系的值的逻辑运算结果是真是假。
 *      逻辑运算的判断结果是boolean值，只有true和false。关于逻辑运算，运算符有优先级高低之分，本运算中存在的运算符优先级为：“！>&&>||，非>与>或”。
 */
public class JudgeWhetherIsSmoothYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个年份：");
        int year = scanner.nextInt();
        //这里要注意的是，被100整除不一定就能被400整除，这里 year%100 != 0 目的就是为了让年数不能为100,当为100的整数但是不为400的整数时，year%100 == 0，条件不成立，返回false
        if (year%4 == 0 && year%100 != 0 || year%400 == 0){
            System.out.println("是闰年");
        }else {
            System.out.println("不是闰年");
        }
    }
}
