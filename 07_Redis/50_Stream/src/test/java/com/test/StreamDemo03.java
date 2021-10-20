package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    筛选（filter）
 */
public class StreamDemo03 {
    @Test
    void demo01(){
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Optional<Integer> any = list.stream().filter(x -> x > 7).findAny();
        System.out.println(any.get());
    }

    @Test
    void demo02(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> collect = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
