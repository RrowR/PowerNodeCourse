package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 3.6.2 统计(count/averaging)
 * Collectors提供了一系列用于数据统计的静态方法：
 *
 * 计数：count
 * 平均值：averagingInt、averagingLong、averagingDouble
 * 最值：maxBy、minBy
 * 求和：summingInt、summingLong、summingDouble
 * 统计以上所有：summarizingInt、summarizingLong、summarizingDouble
 */
public class StreamDemo08 {
    @Test
    void CountStudy(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        // 统计
        Long count = personList.stream().collect(Collectors.counting());
        Long count2 = personList.stream().count();
        System.out.println(count);
        System.out.println(count2);
        // 求平局工资
        Double avgSal = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println("avgSal = " + avgSal);
        // 求工资总和
        Integer sumSal = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        Integer sumSal2 = personList.stream().mapToInt(Person::getSalary).sum();
        System.out.println("sumSal = " + sumSal);
        System.out.println("sumSal2 = " + sumSal2);
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("统计所有:"+collect);
    }
}
