package day06;

/**
 * continue ：退出这一次循环，直接执行下一次循环
 *      如果是for：则直接跑到下一次 程序表达式中
 *      如果是while：直接跑到下一次循环中
 */
public class Demo02Continue {
    public static void main(String[] args) {
//        method01TestContinueFor();
//        method02TestContinueWhile();
        onlineTest01();
    }

    private static void onlineTest01() {
    // 在控制台先打印矩形，然后再打印平行四边形，再然后打印等腰三角形
        //在控制台先打印矩形
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        //然后再打印平行四边形
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        //再然后打印等腰三角形
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - 1 - i; j++) {       // 这里 j 从 0 开始 打印 0 ~ 5 - 1 - i 个空格
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        //再然后打印菱形
        int a = 5;
        for (int i = 0; i < 2 * a; i++) {
            if (i < a){
                for (int j = 0; j < a - 1 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
                /**
                 *  a = 5
                 *  i = 5
                 *  j = 1
                 *  j < 10
                 */
            }else {     // 到这里 i >= a     
                for (int j = 2 * a - i - 1 ; j < a ; j++) {
                    System.out.print(" ");
                }
                for (int j = i - 1; j <= 2 * a - (i - a); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        // 打印空心菱形
        for (int i = 0; i < 2 * a; i++) {
            if (i < a){
                for (int j = 0; j < a - 1 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    if (j == 0 || j == 2 * i){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }

                }
                System.out.println();
                /**
                 *  a = 5
                 *  i = 5
                 *  j = 1
                 *  j < 10
                 */
            }else {     // 到这里 i >= a
                for (int j = 2 * a - i - 1 ; j < a ; j++) {
                    System.out.print(" ");
                }
                for (int j = i - 1; j <= 2 * a - (i - a); j++) {
                    if (j == i - 1 || j == 2 * a - (i - a)){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }



    }

    private static void method02TestContinueWhile() {
        /*  这样写程序会进入死循环：当 i == 3时，进入continue，然后又判断3 < 5 继续continue
        int i = 0;
        while (i < 5){
            if (i == 3){
                continue;
            }
            i++;
            System.out.println(i);
        }*/

        int i = 0;
        while (i < 5){
            int a = i++;
            if (a == 3){
                continue;
            }
            System.out.println(a);
        }


    }

    private static void method01TestContinueFor() {
        for (int i = 0; i < 5; i++) {
            if (i == 3){
                continue;
            }
            System.out.println(i);
        }
    }
}
