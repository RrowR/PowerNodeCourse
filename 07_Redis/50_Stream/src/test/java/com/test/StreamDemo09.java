package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    3.6.3 分组(partitioningBy/groupingBy)
    分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
    分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
 */
public class StreamDemo09 {
    @Test
    void CollectionStudy01(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        // 根据工资是否大于 7800 来进行分组，分为2组
        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 7800));
        System.out.println(collect);
        /*
            public static <T, K> Collector<T, ?, Map<K, List<T>>>
            groupingBy(Function<? super T, ? extends K> classifier) {
                return groupingBy(classifier, toList());
    }
         */
        Map<String, List<Person>> userMap = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(userMap);
        Map<String, Map<String, List<Person>>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println(collect1);
    }
}
