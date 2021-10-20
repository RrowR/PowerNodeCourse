package com.test;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 3.8 提取/组合
 * 流也可以进行合并、去重、限制、跳过等操作。
 */
public class StreamDemo11 {
    @Test
    void Demo01() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};
        Stream<String> s1 = Stream.of(arr1);
        Stream<String> s2 = Stream.of(arr2);
        // 合并两个流并去重
        List<String> list = Stream.concat(s1, s2).distinct().collect(Collectors.toList());
        System.out.println(list);
        // 限制只取出10个数
        List<Integer> list1 = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        System.out.println(list1);
        // 跳过第一个，但是还是限制5个
        List<Integer> list2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());
        System.out.println(list2);
    }
}
