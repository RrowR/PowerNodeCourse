package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 3.6 收集(collect)
 * 3.6.1 归集(toList/toSet/toMap)
 * <p>
 * 因为流不存储数据，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合里。
 * toList、toSet和toMap比较常用，另外还有toCollection、toConcurrentMap等复杂一些的用法。
 */
public class StreamDemo07 {

    @Test
    void CollectionStudy01() {
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> collectList = list.stream().filter(x -> x > 3).collect(Collectors.toList());
        System.out.println(collectList);
        Set<Integer> integerSet = list.stream().filter(x -> x > 3).collect(Collectors.toSet());
        System.out.println(integerSet);
    }

    @Test
    void CollectionStudy02() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        Map<Integer, Person> personMap = personList.stream().filter(x -> x.getSalary() > 7800).collect(Collectors.toMap(person -> (person.getSalary()), o -> o));
        Map<Integer, Person> personMap2 = personList.stream().filter(x -> x.getSalary() > 7800).collect(Collectors.toMap(Person::getSalary, o -> o));
        System.out.println(personMap);
        System.out.println(personMap2);
    }

}
