package day17;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        System.out.println((int) '0');
        do {
            System.out.println("请输入身份证号码");
            String idCard = input.next();
            if (idCard.length() == 18){
                String year = idCard.substring(6, 10);
                String month = idCard.substring(10, 12);
                String day = idCard.substring(12, 14);
                char num = idCard.charAt(16);
                String sex = num % 2 == 0 ? "女" : "男";
                System.out.println("出生于"+year+"年");
                System.out.println("出生于"+month+"月");
                System.out.println("出生于"+day+"日");
                System.out.println("性别"+sex);
            }else {
                System.out.println("输入错误，请重新输入");
                flag = false;
            }
        }while (!flag);
    }
}
