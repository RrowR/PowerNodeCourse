package day04;

import java.util.Scanner;

public class XiaoLianXi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄");
        int age = scanner.nextInt();
        String ifadult = age >= 18 ? "成年" : "未成年";
        System.out.println("您"+ifadult);
    }
}
