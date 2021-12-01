package com.study;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainApp02 {
    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("李四", 99.0);
        map.put("张三", 1.0);
        map.entrySet().stream().filter(entry -> entry.getKey().equals("张三")).forEach(entry -> entry.setValue(100.0));
        System.out.println(map);

    }
}
