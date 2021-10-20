package com.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private Double price;
    private BigDecimal score;
    private List<String> hobby;

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "德玛", "德玛西亚", 30, 3150D, new BigDecimal(1100), Arrays.asList("大宝剑", "睡觉", "锻炼")));
        users.add(new User(2, "亚索", "艾欧尼亚", 25, 6300D, new BigDecimal(1200), Arrays.asList("吹笛子", "睡觉")));
        users.add(new User(3, "辛德拉", "艾欧尼亚", 26, 6300D, new BigDecimal(1300), Arrays.asList("保龄球", "奶茶")));
        users.add(new User(4, "赵信", "德玛西亚", 28, 3150D, new BigDecimal(1400), Arrays.asList("看书", "睡觉", "锻炼")));
        users.add(new User(5, "后裔", "华夏", 99, 7800D, new BigDecimal(1500), Arrays.asList("射箭", "晒太阳")));
        users.add(new User(6, "马可波罗", "意大利", 48, 1350D, new BigDecimal(1600), Arrays.asList("旅游", "游泳")));
    }

    public static void main(String[] args) {
        // 1. 找出住在德玛西亚的用户
        List<User> users = User.users.stream().filter(x -> x.getAddress().equals("德玛西亚")).collect(Collectors.toList());
        System.out.println(users);
        // 2. 拿到所有英雄名字的集合
        List<String> names = User.users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(names);
        // 3. 找到价格最高的英雄的id
        User user = User.users.stream().sorted(Comparator.comparing(User::getPrice).reversed()).limit(1).collect(Collectors.toList()).get(0);
        System.out.println(user);
        // 4. 按照分数由高到低排序
        List<User> collect = User.users.stream().sorted(Comparator.comparing(User::getScore).reversed()).collect(Collectors.toList());
        System.out.println(collect);
        // 5. 找出年龄在25-30岁之间，按照年龄正排序，并且拿到他们的名字
        List<String> collect1 = User.users.stream().filter(x -> x.getAge() >= 25 && x.getAge() <= 30).sorted(Comparator.comparing(User::getAge)).map(User::getName).collect(Collectors.toList());
        System.out.println(collect1);
        // 6. 计算出所有分数的总和
        BigDecimal sum = User.users.stream().map(User::getScore).reduce(BigDecimal::add).get();
        System.out.println(sum);
        // 7. 找出爱好中包含睡觉的英雄，跳过第一个，并且计算他们的平均价格
        Double sumprice = User.users.stream().filter(x -> x.getHobby().contains("睡觉")).skip(0).collect(Collectors.averagingDouble(User::getPrice));
        System.out.println(sumprice);
    }
}
