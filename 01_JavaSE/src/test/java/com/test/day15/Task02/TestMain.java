package com.test.day15.Task02;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入想要制作的披萨(1.培根披萨 2.海鲜披萨)");
        int choosePizza = input.nextInt();
        Pizza pizza = null;
        switch (choosePizza)  {
            case 1:
                BaconPizza baconPizza = new BaconPizza();
                baconPizza.setFoodName("培根pizza");
                System.out.println("请输入培根克数");
                String baconWeight = input.next();
                baconPizza.setFoodAdd(baconWeight);
                pizza = baconPizza;
                break;
            case 2:
                SeaFoodPizza seaFoodPizza = new SeaFoodPizza();
                seaFoodPizza.setFoodName("海鲜pizza");
                System.out.println("请输入配料信息：");
                String msg = input.next();
                seaFoodPizza.setFoodAdd(msg);
                pizza = seaFoodPizza;
                break;
        }
        System.out.println("请输入pizza大小");
        int size = input.nextInt();
        pizza.setFoodSize(size);
        System.out.println("请输入pizza价格");
        double price = input.nextDouble();
        pizza.setFoodPrice(price);

        System.out.println("名称:"+pizza.getFoodName());
        System.out.println("价格:"+pizza.getFoodPrice()+"元");
        System.out.println("大小"+pizza.getFoodSize()+"寸");
        System.out.println("配料"+pizza.getFoodAdd());

    }
}
