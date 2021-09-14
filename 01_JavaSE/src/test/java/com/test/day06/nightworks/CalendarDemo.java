package com.test.day06.nightworks;

import java.util.Scanner;

/**
 * 需求：输入年和月，然后展示这个月有多少天，并且展示这个月是星期几
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = input.nextInt();
        System.out.println("请输入月份:");
        int month = input.nextInt();

        // 设置之前年中的所有日期
        int yearDays = 0;
        // 统计从格林威治时间到当前年的总日期数
        for (int i = 1900; i < year; i++) {
            /*if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                // 是闰年
                yearDays += 366;
            } else {
                // 不是闰年
                yearDays += 365;
            }*/
            yearDays = (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) ? yearDays + 366 : yearDays + 365;
        }
        // 设置当前年的日期数
        int monthDays = 0;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    monthDays += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    monthDays += 30;
                    break;
                case 2:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        // 是闰年
                        monthDays += 29;
                    } else {
                        // 不是闰年
                        monthDays += 28;
                    }
                    break;
                default:
                    System.out.println("您输入的月份有误");
                    break;
            }
        }
        // 判断当前月有多少天
        int monthday = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                monthday = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                monthday = 30;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    // 是闰年
                    monthday = 29;
                } else {
                    // 不是闰年
                    monthday = 28;
                }
                break;
            default:
                System.out.println("您输入的月份有误");
                break;
        }
        // 判断输入的月份第一天是星期几
        int weekNum = (yearDays + monthDays + 1) % 7;
        // 设置布局
        System.out.println("周日\t周一\t周二\t周三\t周四\t周五\t周六");
        // 输出空格数，注意一下这里的排版，开始的空格数等于 weekNum
        for (int i = 0; i < weekNum; i++) {
            System.out.print("\t\t");
        }
        // 输出日历
        for (int i = 1; i <= monthday; i++) {
            System.out.print(i + "\t\t");
            if ((weekNum + i) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
