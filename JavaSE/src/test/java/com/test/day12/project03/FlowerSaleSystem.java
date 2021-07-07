package com.test.day12.project03;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class FlowerSaleSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Flower[] arr = addFlowers();
        do {
            System.out.println("=====================欢迎光临\"七彩鲜花\"销售管理系统======================");
            System.out.println("1.查询销售订单");
            System.out.println("2.修改销售订单");
            System.out.println("3.删除销售订单");
            System.out.println("4.系统退出");
            // 输入的数匹配switch/case
            int num = input.nextInt();
            switch (num){
                case 1:
                    getAllFlowers(arr);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        }while (true);
    }

    private static void getAllFlowers(Flower[] arr) {

    }

    public static Flower[] addFlowers(){
        Flower flower1 = new Flower("1001","金色海岸-香槟玫瑰",10,318.0,new Date(),"王二妮","");
        Flower flower2 = new Flower("1002","初心永不变-白玫瑰",99,538.0,new Date(),"张欣雨","");
        Flower flower3 = new Flower("1003","梦里花开-紫色桔梗",40,148.0,new Date(),"王二妮","");
        Flower flower4 = new Flower("1004","心花怒放-粉色百合",120,188.0,new Date(),"王二妮","");
        Flower flower5 = new Flower("1005","致青春-无声的爱",1000,219.0,new Date(),"张欣雨","");
        Flower[] arr = {flower1,flower2,flower3,flower4,flower5};
        return arr;
    }
}
