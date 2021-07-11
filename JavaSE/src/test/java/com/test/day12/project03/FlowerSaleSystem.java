package com.test.day12.project03;

import com.test.day12.project03.Entity.Flower;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FlowerSaleSystem {
    // 设置全局静态变量和标志
    static Scanner input = new Scanner(System.in);
    static boolean isModified = false;
    public static void main(String[] args) throws ParseException, InterruptedException {
        // 初始化鲜花数组
        ArrayList<Flower> flowers = addFlowers();
        // 创建一个备用数组，用来存放yes/no的结果
        // 格外注意，这里的数据不能遍历出来给另一个arraylist，否则2个对象的地址值一致,到时候操作的时候，如果是遍历进去的会操作2个对象
        ArrayList<Flower> secondFlowers = addFlowers();
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
                    // 执行修改代码，返回的secondFlowers可能是一个修改过的，也可能是一个没有修改过的
                    secondFlowers = alterFlower(secondFlowers);
                    // 当修改成功时才执行下面代码，否则直接break，这里的yes/no是将新数据传入到一个新数组里，直接查询这个新数组
                    if (isModified == true){
                        String next = input.next();
                        if (next.equals("y")){
                            System.out.println("正在查询...");
                            Thread.sleep(1234);
                            System.out.println("修改成功");
                            System.out.println();
                            System.out.println("编号"+"\t\t"+"鲜花名称"+"\t\t"+"销售数量"+"\t\t"+"价格"+"\t\t"+"销售日期"+"\t\t"+"销售员"+"\t\t"+"备注");
                            for (int i = 0; i < secondFlowers.size(); i++) {
                                Flower flower = new Flower(secondFlowers.get(i).getNumber(),secondFlowers.get(i).getName(),secondFlowers.get(i).getSaleCount(),secondFlowers.get(i).getPrice(),secondFlowers.get(i).getDate(),secondFlowers.get(i).getSoldName(),secondFlowers.get(i).getRemark());
                                flowers.set(i,flower);
                            }
                            findAllFlowers(flowers);
                        }else if (next.equals("n")){
                            System.out.println("未修改...");
                            for (int i = 0; i < flowers.size(); i++) {
                                Flower flower = new Flower(flowers.get(i).getNumber(), flowers.get(i).getName(), flowers.get(i).getSaleCount(), flowers.get(i).getPrice(), flowers.get(i).getDate(), flowers.get(i).getSoldName(), flowers.get(i).getRemark());
                                secondFlowers.set(i,flower);
                            }
                        }else {
                            System.out.println("您输入的选择不对，已退出");
                        }
                    }
                    break;
                case 3:
                    System.out.println("当前订单有：");
                    findAllFlowers(flowers);
                    System.out.println("------------------分割线-------------------");
                    System.out.println("请输入要删除的订单号：");
                    String number = input.next();
                    if (findFlower(flowers,number) != null){
                        deleteFlower(flowers,number);
                        System.out.println("正在删除，请稍等...");
                        Thread.sleep(1234);
                        findAllFlowers(flowers);
                        // 将删除的代码再次"拷贝"回secondFlowers
                        for (int i = 0; i < flowers.size(); i++) {
                            Flower flower = new Flower(flowers.get(i).getNumber(), flowers.get(i).getName(), flowers.get(i).getSaleCount(), flowers.get(i).getPrice(), flowers.get(i).getDate(), flowers.get(i).getSoldName(), flowers.get(i).getRemark());
                            secondFlowers.set(i,flower);
                        }
                        secondFlowers.remove(secondFlowers.size()-1);
                    }else {
                        System.out.println("您输入的不对，请重新再来");
                    }
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
            System.out.println("您要修改的信息如下");
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
            System.out.println("您确定要修改吗y/n");
            isModified = true;
        }else {
            System.out.println("您要修改的订单不存在！！！");
            isModified = false;
        }
        // 这里返回被修改过的flowers,也可能没有被修改过
        return flowers;
    }

    private static void deleteFlower(ArrayList<Flower> flowers,String number){

        Flower flower = findFlower(flowers, number);
        flowers.remove(flower);
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
