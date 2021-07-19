package com.test.day18.homework;

import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Test
    public void Task02() throws ParseException {
        /*
            2.	接收从键盘输入的字符串格式的年龄，分数和入学时间，转换为整数、浮点数、日期类型，并在控制台输出。
            提示：使用包装类Integer、Double和日期转换类DateFormat实现
         */
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年龄");
        Integer age = input.nextInt();
        System.out.println("请输入分数");
        Double score = input.nextDouble();
        System.out.println("请输入入学时间");
        String schoolTime = input.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(schoolTime);
        System.out.println(date);
    }

    @Test
    public void Task03(){
        /*
            3.	根据交通信号灯颜色决定汽车停车、行驶和慢行
            提示：使用枚举实现
         */
        TrafficLight color = TrafficLight.RED;
        switch (color){
            case GREEN:
                System.out.println("允许通行");
                break;
            case RED:
                System.out.println("静止通行");
                break;
            case YELLOW:
                System.out.println("马上禁止通行");
                break;
        }
    }

    @Test
    public void Task04(){
        /*
            4.	编写递归算法程序：一列数的规则如下: 1、1、2、3、5、8、13、21、34...... 求数列的第40位数是多少。
         */
        System.out.println(RecursionToSum(5));
    }

    @Test
    public void Task05(){
        /*
            5.	以树状结构输出计算机某个指定文件夹下的所有的文件和子文件夹名称。
            提示：使用File的方法，并结合递归实现
         */
        File file = new File("src");
        getAllFiles(file);
    }

    private void getAllFiles(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                getAllFiles(f);
            }else {
                System.out.println(f);
            }
        }
    }


    private int RecursionToSum(int times){
        if (1 <= times && times <= 2){
            return 1;
        }else {
            // 这里我只管拆，能拆就拆，拆到if截止
            return RecursionToSum(times - 1) + RecursionToSum(times - 2);
        }
    }

    private enum TrafficLight{
        RED,GREEN,YELLOW
    }
}

