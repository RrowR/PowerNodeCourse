package com.test.day12.project03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class FlowerSaleSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("=====================欢迎光临\"七彩鲜花\"销售管理系统======================");
            System.out.println("1.查询销售订单");
            System.out.println("2.修改销售订单");
            System.out.println("3.删除销售订单");
            System.out.println("4.系统退出");
            // 输入的数匹配switch/case
            int num = input.nextInt();
            ArrayList<Flower> flowers = addFlowers();
            switch (num){
                case 1:
                    System.out.println("编号\t鲜花名称\t销售数量\t价格\t销售日期\t销售员\t备注");
                    for (Flower flower : flowers) {
                        System.out.println(flower.getNumber()+"\t"+flower.getName()+"\t"+flower.getSaleCount()+"\t"+flower.getPrice()+"\t"+flower.getDate()+"\t"+flower.getName()+"\t"+flower.getRemark());
                    }
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

    public static ArrayList<Flower> addFlowers(){
        ArrayList<Flower> flowers = new ArrayList<>();
        flowers.add(new Flower("1001","金色海岸-香槟玫瑰",10,318.0,new Date(),"王二妮",""));
        flowers.add(new Flower("1002","初心永不变-白玫瑰",99,538.0,new Date(),"张欣雨",""));
        flowers.add(new Flower("1003","梦里花开-紫色桔梗",40,148.0,new Date(),"王二妮","眼波如水，映出窗外繁星点点"));
        flowers.add(new Flower("1004","心花怒放-粉色百合",120,188.0,new Date(),"王二妮","内层银灰色厚棉纸，外层深蓝色条纹纸，银灰色缎带"));
        flowers.add(new Flower("1005","致青春-无声的爱",1000,219.0,new Date(),"张欣雨","我爱你，胜过爱爱情，更胜过爱自己"));
        return flowers;
    }
}
