package com.test.day14.Task03;

import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        UserPackage users = new UserPackage();
        Scanner input = new Scanner(System.in);
        System.out.print("姓名: ");
        String userName = input.next();
        users.setUserName(userName);
        System.out.print("年龄: ");
        int age = input.nextInt();
        users.setAge(age);
        System.out.print("工作年限: ");
        int workYear = input.nextInt();
        users.setWorkExperience(workYear);
        System.out.print("目前就职于: ");
        String worksIn = input.next();
        users.setWorksIn(worksIn);
        System.out.print("职务是: ");
        String carrer = input.next();
        users.setCarrer(carrer);
        System.out.println("===========================================");
        System.out.println("姓名:"+users.getUserName());
        System.out.println("年龄:"+users.getAge());
        System.out.println("技术方向:"+users.getTechnologyDirection());
        System.out.println("工作年限:"+users.getWorkExperience());
        System.out.println("目前就职于:"+users.getWorksIn());
        System.out.println("职位是:"+users.getCarrer());

    }
}
