package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    3.4 映射(map/flatMap)
    映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
    map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
    flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
 */
public class StreamDemo05 {

    // 案例一：英文字符串数组的元素全部改为大写。整数数组每个元素+3。
    @Test
    void demo01() {
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        Stream<String> strList = Arrays.stream(strArr).map(String::toUpperCase);
        strList.forEach(System.out::println);

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        Stream<Integer> stream = intList.stream().map(x -> x + 3);
        stream.forEach(System.out::println);
    }

    // 案例二：将员工的薪资全部增加1000。
    @Test
    void demo02() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 不改变原集合的方式
        List<Person> newList = personList.stream().map(x -> {
            Person person = new Person(x.getName(), x.getSalary() + 1000, null, null);
            return person;
        }).collect(Collectors.toList());
        System.out.println("改动前====>" + personList);
        System.out.println("改动后====>" + newList);

        // 改变原集合的方式
        List<Person> list = personList.stream().map(x -> {
            x.setSalary(x.getSalary() + 1000);
            return x;
        }).collect(Collectors.toList());        // 这里必须要收集起来，不然原集合也不回改变
        System.out.println("改动前====>" + personList);
        System.out.println("改动后====>" + list);
    }

    // 案例三：将两个字符数组合并成一个新的字符数组。直接返回一个流
    @Test
    void demo03() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect = list.stream().flatMap(x -> {
            String[] split = x.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println("改动后====>" + list);
        System.out.println("改动后====>" + collect);
    }
}
