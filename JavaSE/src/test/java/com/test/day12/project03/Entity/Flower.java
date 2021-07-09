package com.test.day12.project03.Entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flower {
    private String number;
    private String name;
    private int saleCount;
    private double price;
    private Date date;
    private String soldName;
    private String remark;
}
