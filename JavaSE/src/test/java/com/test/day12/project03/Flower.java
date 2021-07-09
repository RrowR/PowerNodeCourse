package com.test.day12.project03;

import java.util.Date;

public class Flower {
    private String Number;
    private String Name;
    private int saleCount;
    private double price;
    private Date date;
    private String soldName;
    private String remark;

    public Flower(String number, String name, int saleCount, double price, Date date, String soldName, String remark) {
        Number = number;
        Name = name;
        this.saleCount = saleCount;
        this.price = price;
        this.date = date;
        this.soldName = soldName;
        this.remark = remark;
    }

    public Flower() {
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSoldName() {
        return soldName;
    }

    public void setSoldName(String soldName) {
        this.soldName = soldName;
    }

    public String getRemark() {
        if (remark == null){
            return "";
        }
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
