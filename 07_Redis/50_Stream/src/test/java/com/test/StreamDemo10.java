package com.test;

import com.study.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 3.6.4 接合(joining)
 * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
 * 3.6.5 归约(reducing)
 * Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持。
 * 3.7 排序(sorted)
 * sorted，中间操作。有两种排序：
 * sorted()：自然排序，流中元素需实现Comparable接口
 * sorted(Comparator com)：Comparator排序器自定义排序
 */
public class StreamDemo10 {
    @Test
    void Method01() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        String names = personList.stream().map(x -> x.getName()).collect(Collectors.joining(","));
        System.out.println(names);
    }

    @Test
    void Method02() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        Integer sum = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> {
            System.out.println(i);
            System.out.println(j);
            System.out.println("-------");
            return i + j - 5000;
        }));
        System.out.println(sum);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());
    }

    @Test
    void Method03() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));
        // 根据名称自然排序
        List<String> namesOrderByName = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        System.out.println(namesOrderByName);
        // 倒序排序
        List<String> namesOrderByName2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        System.out.println(namesOrderByName2);
        // 先按工资再按年龄升序排序
        List<String> list = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
        System.out.println(list);
        // 先按工资再按年龄自定义排序（降序）
        List<String> list1 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing((o1, o2) -> o2.getAge() - o1.getAge())).map(Person::getName).collect(Collectors.toList());
        System.out.println(list1);
    }
}
