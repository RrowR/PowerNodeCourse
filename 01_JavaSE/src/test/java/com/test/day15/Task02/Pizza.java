package com.test.day15.Task02;

public class Pizza {
    private String foodName;
    private int foodSize;
    private double foodPrice;
    private String foodAdd;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodSize() {
        return foodSize;
    }

    public void setFoodSize(int foodSize) {
        this.foodSize = foodSize;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Pizza() {
    }

    public String getFoodAdd() {
        return foodAdd;
    }

    public void setFoodAdd(String foodAdd) {
        this.foodAdd = foodAdd;
    }

    public Pizza(String foodName, int foodSize, double foodPrice, String foodAdd) {
        this.foodName = foodName;
        this.foodSize = foodSize;
        this.foodPrice = foodPrice;
        this.foodAdd = foodAdd;
    }
}
