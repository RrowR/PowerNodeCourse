package com.test.day99finalTask.task01;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * 使用字符缓冲流从message.txt里面取出所有数据
 * 创建一个WorldCup这样一个类
 * |--year
 * |--country
 * |--winner
 * 从读取出来流里面解析数据放到List<WorldCup>里面
 * 选做：根据year进行排序
 * 使用Collections.sort()
 */
public class Task01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("01_JavaSE/src/message.txt"));
        ArrayList<WorldCup> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.trim().split(",");
            WorldCup worldCup = new WorldCup();
            Long year = Long.parseLong(split[0]);
            String country = split[1];
            String winner = split[2];
            worldCup.setYear(new Date(year));
            worldCup.setCountry(country);
            worldCup.setWinner(winner);
            list.add(worldCup);
        }
        Collections.sort(list, (o1, o2) -> o1.getYear().getTime() > o2.getYear().getTime() ? 1 : -1);
        // 结构太丑，优化一下，转换为json，还可以解决日期问题
        ObjectMapper mapper = new ObjectMapper();
        String jsonArrayString = mapper.writeValueAsString(list);
        System.out.println(jsonArrayString);
    }
}
