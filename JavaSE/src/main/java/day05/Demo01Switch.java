package day05;

import java.util.Scanner;

/**
 * switch注意点：
 *      1.case 后的数必须是final修饰
 *      2.存在代码穿透
 *      3.当case都没找到，才执行default
 *  switch和if的区别：
 *      1.switch适用于固定值匹配，if适用于条件判断来是否执行代码块
 *      2.switch不支持boolean、浮点类型，且 case 里的常量必须是final的
 *      3.来进行固定值匹配的时候，必须使用switch
 */
public class Demo01Switch {
    public static void main(String[] args) {
//        searchForScore();
//        selectFruit();
        autoCreatedForScore();
    }

    /**
     * java.lang.Object
     *   继承者 java.lang.Math
     * static double random()
     *           返回带正号的 double 值，该值大于等于 0.0 且 小于 1.0。
     */
    private static void autoCreatedForScore() {
        double random = Math.random();
        int s = (int)((random*101));
        System.out.println(s);
            switch (s/10) {
                //为了增强代码的不重复性，可以让其中一个case为空
                case 10:
                /*System.out.println("成绩优秀");
                break;*/
                case 9:
                    System.out.println("成绩优秀");
                    break;
                //为了增强代码的不重复性，可以让其中一个case为空
                case 8:
                /*System.out.println("成绩良好");
                break;*/
                case 7:
                    System.out.println("成绩良好");
                    break;
                case 6:
                    System.out.println("成绩及格");
                    break;
                default:
                    System.out.println("成绩不合格");
                    break;
        }
    }

    private static void searchForScore() {
        /*2、	接收一个人的成绩，如果成绩为: 90(包含)到100(包含)输出优秀，70(包含)到90输出良好，60(包含)到70输出及格，60分以下输出不及格。
         *   提示：可以先让成绩除以10然后强转成int，根据强转的int区间来判断成绩是否符合区间，从10倍数量级变成了1倍
         * */
        Scanner input = new Scanner(System.in);
        System.out.print("请输入成绩:");
        Double score = input.nextDouble();
        //提高程序健壮性，开始就判断成绩是否合法
        if (score > 100.0 || score < 0.0) {
            System.out.println("成绩不合法");
        } else {
            int s = (int) (score / 10);
            switch (s) {
                //为了增强代码的不重复性，可以让其中一个case为空
                case 10:
                /*System.out.println("成绩优秀");
                break;*/
                case 9:
                    System.out.println("成绩优秀");
                    break;
                //为了增强代码的不重复性，可以让其中一个case为空
                case 8:
                /*System.out.println("成绩良好");
                break;*/
                case 7:
                    System.out.println("成绩良好");
                    break;
                case 6:
                    System.out.println("成绩及格");
                    break;
                default:
                    System.out.println("成绩不合格");
                    break;
            }
        }
    }

    /*3、	查询水果的价格，根据输入水果(fruit)的名字，输出对应的水果的价格，例如苹果6块/斤，香蕉3元/斤，榴莲20元/斤，西瓜0.8元/斤。*/
    private static void selectFruit() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入水果类型:");
        String fruit = input.next();
        switch (fruit) {
            case "apple":
                System.out.println("6元/斤");
                break;
            case "banana":
                System.out.println("3元/斤");
                break;
            case "liulian":
                System.out.println("20元/斤");
                break;
            case "watermelon":
                System.out.println("0.8/斤");
                break;
            default:
                System.out.println("没有这种水果");
                break;
        }
    }
}
