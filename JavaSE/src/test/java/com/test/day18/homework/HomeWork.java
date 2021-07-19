package com.test.day18.homework;

import org.junit.Test;

import java.util.Scanner;

public class HomeWork {

    @Test
    public void Task01(){
        /*
            1.	验证键盘输入的用户名不能为空，长度大于6，不能有数字。
            提示：使用字符串String类的相关方法完成
         */
        System.out.println("请输入一个长度大于6的字符串");
        Scanner input = new Scanner(System.in);
        String next = input.next();
        Boolean flag = false;
        if (next.length() > 6){
            for (int i = 0; i < next.length(); i++) {
                char c = next.charAt(i);
                if ("1".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("2".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("3".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("4".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("5".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("6".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("7".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("8".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("9".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }else if ("0".equals(c+"")){
                    System.out.println("包含了："+c);
                    flag = true;
                    break;
                }
            }
        }else {
            System.out.println("您输入的字符串长度小于等于6");
        }
        if (flag == false){
            System.out.println("您输入的数有效为："+next);
        }

    }
}
