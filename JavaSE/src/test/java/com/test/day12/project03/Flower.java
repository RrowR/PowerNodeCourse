package com.test.day12.project03;

import java.util.Date;
import java.util.Objects;

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
}
