package day04;

import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个用户名:");
        String username = input.next();
        System.out.print("请输入一个密码");
        String password = input.next();
        if (username.equals("admin") && password.equals("123456")) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }
}
