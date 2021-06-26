package com.test.day04.selfstudyinnight;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ExaminationsInNight {
    @Test
    public void task01() {
        /*1、	判断一个学生的成绩，如果90（包含）~100（包含）为优秀，70（包含）~90为良好，60（包含）~70为及格，60分以下输出不及格。*/
        Scanner input = new Scanner(System.in);
        System.out.print("请输入成绩:");
        double score = input.nextDouble();
        if (score < 0 && score > 100) {
            System.out.println("您输入的成绩不合法");
        } else if (score > 90) {
            System.out.println("您的成绩很优秀");
        } else if (score > 70) {
            System.out.println("成绩良好");
        } else if (score > 60) {
            System.out.println("成绩及格");
        } else {
            System.out.println("您的成绩不合格");
        }
    }

    @Test
    public void task02() {
        /*输入一个整数month代表月份，根据月份输出对应的季节 春季：3、4、5 夏季：6、7、8 秋季：9、10、11 冬季：12、1、2*/
        Scanner input = new Scanner(System.in);
        System.out.print("请输入月份:");
        int month = input.nextInt();
        if (month == 3 || month == 4 || month == 5) {
            System.out.println("当前正值春季");
        } else if (month == 6 || month == 7 || month == 8) {
            System.out.println("当前正是夏季");
        } else if (month == 9 || month == 10 || month == 11) {
            System.out.println("当前正是秋季");
        } else if (month == 12 || month == 1 || month == 2) {
            System.out.println("当前正是冬季");
        } else {
            System.out.println("您输入的月数不合法");
        }
    }

    @Test
    public void test03() {
        /**
         * 3、	输入工作年限(year)和月薪(money)，然后计算出应得的年终奖。
         *      工作不满1年（不包含）： 发月薪的1倍月薪年终奖；如果月薪大于8000, 那么就是发1.2倍月薪年终奖。
         *      工作不满3年（不包含）：发月薪的2倍月薪年终奖；如果月薪大于15000, 那么就是发3倍月薪年终奖。
         *      工作满3年（包含）以上：发月薪的3倍月薪年终奖；如果月薪大于20000, 那么就是发4倍月薪年终奖。
         */
        double sum;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的薪水:");
        double salaries = input.nextDouble();
        System.out.println("请输入工作年限:");
        Double worktime = input.nextDouble();
        if (worktime >= 3.0) {
            sum = salaries > 20000.0 ? salaries * 4 : salaries * 3;
            System.out.println("您的年终奖为:"+sum);
        } else if (worktime >= 1.0) {
            sum = salaries > 15000.0 ? salaries * 3 : salaries * 2;
            System.out.println("您的年终奖为:"+sum);
        } else {
                sum = salaries > 8000.0 ? salaries * 1.2 : salaries * 1;
            System.out.println("您的年终奖为:"+sum);
        }
    }

    @Test
    public void task04() {
        /**
         * 录入一个年份，判断其是否为闰年。
         * 闰年的计算方法：年数能被4整除，并且不能被 100整除；或者能被400整除的整数年份。
         */
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = input.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + "为闰年");
        } else {
            System.out.println(year + "不为闰年");
        }
    }

    @Test
    public void task05() {
        /**
         * 输入时（hour）、分（minute）、秒（second）的一个具体时间，要求打印出它的下一秒出来（一天24小时）。
         * 例如输入的是23时59分59秒，则输出00:00:00；例如输入17时09分59秒，则输出17:10:00。
         */
        Scanner input = new Scanner(System.in);
        System.out.print("请输入小时:");
        int hour = input.nextInt();
        System.out.print("请输入分钟:");
        int minute = input.nextInt();
        System.out.print("请输入秒钟:");
        int second = input.nextInt();
        if (hour > 24 || hour < 0 || minute > 60 || minute < 0 || second > 60 || second < 0) {
            System.out.println("您输入的时间有误");
        } else {
            //获取当前时间的下一秒
            second++;
//            如果second为60秒，那么就将这个秒钟重置为0，并且让minute+1
            //这里使用嵌套循环也会出现一个问题，当输入的时间是11:60:24  则分钟不会进行进位，但是这种情况一般是不存在的，别人不会这样输入，一定是从秒钟开始进位
            if (60 == second) {
                second = 0;
                minute++;
//                如果minute为60，那么就将这个minute重置为0，并且让hour+1
                if (60 == minute) {
                    minute = 0;
                    hour++;
                    if (24 == hour) {
                        hour = 0;
                    }
                }
            }
/*            //这里使不使用嵌套都是可以的，但是这样效率会变低，因为每次都会进行判断是否为60，没进入进位就不需要进入判断
            if (60 == second){
                second = 0;
                minute++;
            }
            if (60 == minute){
                minute = 0;
                hour++;
            }
            if (24 == hour){
                hour = 0;
            }*/

            System.out.println();
            String hourStr = hour >= 10 ? "" + hour : "0" + hour;
            String minuteStr = minute >= 10 ? "" + minute : "0" + minute;
            String secondStr = second >= 10 ? "" + second : "0" + second;
            System.out.println("时间为：" + hourStr + "时" + minuteStr + "分" + secondStr + "秒");
        }
    }
}
