package day07;
import java.util.Scanner;

/**
 * 因为1900年1月1日正好是星期一， 假设输入的是：1901年3月，1901年3月1日前面有几个空格
 *		([1900, 1901)的总天数  + [1901年1月, 1901年3月)的总天数 + 1) % 7
 * 实现步骤：
 * 	 1)通过Scanner获取年(year)和月(month)
 * 	 2)获取[1900, year)的总天数 + [year年1月， year年month月)的总天数
 * 		从而获取到year年month月的1号前面有几个空格
 *   3)获取year年month月的总天数
 *   4)实现year年month月的日历布局
 */
public class CalendarDemo01Theacher {
    /**
     * 设置Layout布局
     * @param yearDays  传入的总年日期天数（除今年）
     * @param monthDays 传入的总月日期天数（除当月）
     * @param monthDay  当前月的天数（当月天数）
     */
    public static void layOutCalendar(int yearDays,int monthDays,int monthDay){
        // 4.实现日历的布局
        // 4.1获取总天数
        int allDays = yearDays + monthDays;
        // 4.2获取year年month的1号前面有多少个空格
        int temp = (allDays + 1) % 7;
        // 4.3输出星期几
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
        // 4.4先展示空格数
        for(int i = 0; i < temp; i++) {
            System.out.print("\t\t");
        }
        // 4.5后展示当前月的天数
        for(int i = 1; i <= monthDay; i++) {
            System.out.print(i + "\t\t");
            // 当空格+i的个数为7de倍数时，执行换行操作
            if((temp + i) % 7 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 获取当前月的天数
     * @param year  当前年
     * @param month 当前月
     * @return
     */
    public static int getCurrentMonthDays(int year,int month){
        // 3.获取year年month月的总天数
        int monthDay = 0; // 用于保存month月的天数
        switch(month) {
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                return  31;
            case 4:case 6:case 9:case 11:
                return  30;
            case 2:
                return monthDay = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
            default:
                throw new IllegalArgumentException("您输入的如期格式不对");
        }
        // 这里不需要return，因为根本走不到这里来
    }

    /**
     * 获取当前年的月数日期一共是多少天
     * @param year      传入的当前年
     * @param month     传入的月
     * @return
     */
    public static int getMonthDays(int year,int month){
        // 2.2获取[year年1月， year年month月)的总天数
        int monthDays = 0; // 用于保存月的总天数
        for(int i = 1; i < month; i++) {
            monthDays += getCurrentMonthDays(year,i);
        }
        return monthDays;
    }

    /**
     * 根据年获取当前年之前的总日期
     * @param year  输入当前年
     * @return  总日期数
     */
    public static int getYearDays(int year){
        // 2.获取[1900, year)的总天数 + [year年1月， year年month月)的总天数
        // 2.1先获取[1900, year)的总天数
        int yearDays = 0; // 用于保存年的总天数
        for(int i = 1900; i < year; i++) {
            yearDays += ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) ? 366 : 365;
        }
        return yearDays;
    }

    public static void main(String[] args) {
        // 1.通过Scanner获取年(year)和月(month)
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年：");
        int year = input.nextInt();
        System.out.print("请输入月：");
        int month = input.nextInt();
        int yearDays = getYearDays(year);
        int monthDays = getMonthDays(year, month);
        int monthDay = getCurrentMonthDays(year, month);
        layOutCalendar(yearDays,monthDays,monthDay);
    }
}
