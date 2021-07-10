package com.test.day12.project03;

import com.test.day12.project03.Entity.Flower;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FlowerSaleSystem {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        // 初始化鲜花数组
        ArrayList<Flower> flowers = addFlowers();
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
                    System.out.println("编号"+"\t\t"+"鲜花名称"+"\t\t"+"销售数量"+"\t\t"+"价格"+"\t\t"+"销售日期"+"\t\t"+"销售员"+"\t\t"+"备注");
                    findAllFlowers(flowers);
                    break;
                case 2:
                    alterFlower(flowers);
                    System.out.println("您确定要修改吗y/n");
                    String next = input.next();
                    if (next.equals("y")){

                    }
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        }while (true);
    }

    private static ArrayList<Flower> alterFlower(ArrayList<Flower> flowers) throws ParseException {
        System.out.println("请输入销售编号：");
        String number = input.next();
        Flower flower = findFlower(flowers, number);
        if (flower != null){
            System.out.println("您要查的信息如下");
            System.out.println("编号"+"\t\t"+"鲜花名称"+"\t\t"+"销售数量"+"\t\t"+"价格"+"\t\t"+"销售日期"+"\t\t"+"销售员"+"\t\t"+"备注");
            System.out.println(flower.getNumber()+"\t\t"+flower.getName()+"\t\t"+flower.getSaleCount()+"\t\t"+flower.getPrice()+"\t\t"+flower.getDate()+"\t\t"+flower.getSoldName()+"\t\t"+flower.getRemark());
            System.out.println("请修改后的鲜花名称");
            String alterName = input.next();
            flower.setName(alterName);
            System.out.println("请输入要修改的数量");
            int alterNum = input.nextInt();
            flower.setSaleCount(alterNum);
            System.out.println("请输入修改后的鲜花价格");
            double alterprice = input.nextDouble();
            flower.setPrice(alterprice);
            System.out.println("请输入修改后的日期\"yyyy-MM-dd\"");
            String alterDate = input.next();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // 将字符串类型的日期解析成Date类型
            Date date = simpleDateFormat.parse(alterDate);
            flower.setDate(date);
            System.out.println("请输入修改后的售后员");
            String alterSolder = input.next();
            flower.setSoldName(alterSolder);
            System.out.println("请输入修改后的备注");
            String alterRemark = input.next();
            flower.setRemark(alterRemark);
        }else {
            System.out.println("您要修改的订单不存在！！！");
        }
        return flowers;
    }

    public static Flower findFlower(ArrayList<Flower> flowers,String number) {
        for (Flower flower : flowers) {
            if (flower.getNumber().equals(number)){
                return flower;
            }
        }
        return null;
    }
    
    public static void findAllFlowers(ArrayList<Flower> flowers){
        for (Flower flower : flowers) {
            System.out.println(flower.getNumber()+"\t\t"+flower.getName()+"\t\t"+flower.getSaleCount()+"\t\t"+flower.getPrice()+"\t\t"+flower.getDate()+"\t\t"+flower.getSoldName()+"\t\t"+flower.getRemark());
        }
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
