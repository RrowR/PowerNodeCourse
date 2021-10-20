package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 3.5 归约(reduce)
 * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
 */
public class StreamDemo06 {
    @Test
    void Study01() {
        // 案例一：求Integer集合的元素之和、乘积和最大值。
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        System.out.println(sum.get());
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        System.out.println(sum2.get());
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);
        System.out.println(sum3);
        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        System.out.println("数组乘积为:" + product.get());

        // 比较取最大值
        System.out.println(list.stream().reduce((x, y) -> x > y ? x : y).get());
        // 比较取最大值方式2
        Integer maxNum = list.stream().reduce(0, Integer::max);
        System.out.println(maxNum);
    }

    // 案例二：求所有员工的工资之和和最高工资。
    @Test
    void Study02() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Integer> salSum = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("方式1工资之和为:" + salSum.get());
        Integer salSum2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), (sum1, sum2) -> sum1 + sum2);
        System.out.println("方式2工资之和为:" + salSum.get());
        Integer salSum3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);
        System.out.println("方式3工资之和为:" + salSum.get());

        System.out.println("方式1最高工资为:"+personList.stream().map(Person::getSalary).reduce(Integer::max).get());


    }

}
