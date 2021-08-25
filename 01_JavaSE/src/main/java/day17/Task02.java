package day17;

import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入带空格的拼音");
        String name = input.nextLine();
        String[] s = name.split(" ");
        String userName = "";
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length()).toLowerCase();
            userName += s[i];
        }
        System.out.println(userName);
    }
}
