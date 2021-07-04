package com.test.day09.nightwork;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 双色球
 * 二、	项目需求
 * 双色球投注区分为红色球号码区和蓝色球号码区，
 * 红色球号码区由1-33共33个号码组成，蓝色球号码区由1-16共16个号码组成。
 * 投注时选择6个红球号码和1个蓝球号码组成一注进行单式投注，每注金额2元。
 * 一等奖：投注号码与当期开奖号码全部相同（顺序不限，下同），即中奖；
 * 二等奖：投注号码与当期开奖号码中的6个红色球号码相同，即中奖；
 * 三等奖：投注号码与当期开奖号码中的任意5个红色球号码和1个蓝色球号码相同，即中奖；
 * 四等奖：投注号码与当期开奖号码中的任意5个红色球号码相同，或与任意4个红色球号码和1个蓝色球号码相同，即中奖；
 * 五等奖：投注号码与当期开奖号码中的任意4个红色球号码相同，或与任意3个红色球号码和1个蓝色球号码相同，即中奖；
 * 六等奖：投注号码与当期开奖号码中的1个蓝色球号码相同，即中奖。
 * 显示中奖结果的同时显示您一共下注人民币？？元，累计中奖人民币？？元
 */

public class DichronmaticBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ticketsCount;
        // 定义存储球的数组（存储7个int类型）
        int[] doubleColorBallContain = new int[7];
        int[] luckeyBall = getLuckyBall();
        int red = 0;
        int blue = 0;
        int cost;
        int oneTicketCost = 2;
        boolean flag = false;
        do {
            System.out.println("****欢迎来到双色球系统****");
            System.out.println("\t 1.购买彩票");
            System.out.println("\t 2.查看开奖");
            System.out.println("\t 3.退出");
            System.out.println("**************************");
            System.out.println();
            int options = input.nextInt();
            switch (options) {
                case 1:
                    System.out.println("欢迎来到购票系统ヾ(≧▽≦*)o");
                    System.out.println("请问输入您要购买的彩票数量:");
                    ticketsCount = input.nextInt();
                    // 存储6个球的数组
                    for (int i = 0; i < doubleColorBallContain.length; i++) {
                        if (i <= 5) {
                            System.out.print("请输入第" + (i + 1) + "个红球的号数【只能在1~33之间】");
                            red = input.nextInt();
                            // 将红球赋值给数组
                            doubleColorBallContain[i] = red;
                        } else {
                            System.out.print("请输入蓝色球的号数【只能在1~16之间】");
                            blue = input.nextInt();
                            doubleColorBallContain[i] = blue;
                        }
                    }
                    cost = ticketsCount * oneTicketCost;
                    System.out.println("您此次的彩票费用为："+ cost + "元");
                    // 选球已经完成的标志
                    flag = true;
                    break;
                case 2:
                    if (flag == true) {
                        flag = false;
                        int[] resultOfTwoColorBall = compareTwoArray(doubleColorBallContain, luckeyBall);
                        for (int i = 0; i < resultOfTwoColorBall.length; i++) {
                            if (i == 0) {
                                red = resultOfTwoColorBall[i];
                            } else {
                                blue = resultOfTwoColorBall[i];
                            }
                        }
                        int winNum = red + blue;
                            switch (winNum) {
                                case 7:
                                    System.out.println("恭喜您获得一等奖");
                                    break;
                                case 6:
                                    if (red == 6) {
                                        System.out.println("恭喜您获得二等奖");
                                        break;
                                    } else {
                                        System.out.println("恭喜您获得三等奖");
                                        break;
                                    }
                                case 5:
                                    if (red == 5 || (red == 4 && blue == 1)) {
                                        System.out.println("恭喜您获得四等奖");
                                        break;
                                    } else {
                                        System.out.println("很遗憾，您没有中奖");
                                        break;
                                    }
                                case 4:
                                    if (red == 4 || (red == 3 && blue == 1)) {
                                        System.out.println("恭喜您获得五等奖");
                                        break;
                                    } else {
                                        System.out.println("很遗憾，您没有中奖");
                                        break;
                                    }
                                case 1:
                                    if (blue == 1) {
                                        System.out.println("恭喜您获得六等奖");
                                        break;
                                    } else {
                                        System.out.println("很遗憾，您没有中奖");
                                        break;
                                    }
                                default:
                                    System.out.println("很遗憾您没有中奖");
                                    break;
                            }
                    } else {
                        System.out.println("你选的号码还没有完成，请回去重新输入");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("已退出当前系统");
                    return;
            }
        } while (true);
    }

    /**
     * 对比两个数组里的内容是否相等
     *
     * @param A 客户选的号码数
     * @param B 幸运池里的中奖号码
     */
    public static int[] compareTwoArray(int[] A, int[] B) {
        int[] twoMatchResult = new int[2];
        int redMatch = 0;
        int buleMatch = 0;
        int i = 0;
        for (; i < A.length - 1; i++) {
            for (int j = 0; j < B.length - 1; j++) {
                if (A[i] == B[j]) {
                    redMatch++;
                }
            }
        }
        twoMatchResult[0] = redMatch;
        if (A[i] == B[i]) {
            buleMatch++;
        }
        twoMatchResult[1] = buleMatch;
        return twoMatchResult;
    }

    public static int[] getLuckyBall(){
        // 红色球号码区由1-33共33个号码组成，蓝色球号码区由1-16共16个号码组成。投注时选择6个红球号码和1个蓝球号码组成一注进行单式投注，每注金额2元。
        int[] arr = new int[7];
        double random = 0;
        HashSet<Integer> redSet = new HashSet<>();
        // 这里要去重，使用hashset吧
        while (true){
            random = Math.random();
            redSet.add((int)((random*33)+1));
            if (redSet.size() == 6){
                break;
            }
        }
        Iterator<Integer> redIterator = redSet.iterator();
        for (int i = 0; i < arr.length - 1; i++) {
            if (redIterator.hasNext()){
                arr[i] = redIterator.next();
            }
        }
        int blue = (int) ((random * 16) + 1);
        arr[arr.length - 1] = blue;
        return arr;
    }
}
