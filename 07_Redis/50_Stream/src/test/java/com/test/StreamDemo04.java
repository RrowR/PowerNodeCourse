package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.*;

/*
    聚合（max/min/count)
 */
public class StreamDemo04 {
    @Test
    void Test01(){
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> optional = list.stream().max(Comparator.comparing(String::length));
        System.out.println(optional.get());
    }

    @Test
    void Test02(){
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println(max.get());

        Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("max1 = " + max1.get());
    }

    // 案例三：获取员工工资最高的人。
    @Test
    void Test03(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> maxSal = personList.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println(maxSal.get().getSalary());
    }

    // 案例四：计算Integer集合中大于6的元素的个数。
    @Test
    void Test04(){
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println(count);
    }




}
