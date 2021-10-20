package com.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *  3.1 遍历/匹配（foreach/find/match）
 */
public class StreamDemo02 {
    @Test
    void demo01(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.stream().filter(x -> x > 3).forEach(System.out::println);
    }

    @Test
    void demo02(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // 查找第一个
        Optional<Integer> any = list.stream().filter(x -> x > 2).findFirst();
        System.out.println(any.get());
    }

    @Test
    void demo03(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // 匹配任意(适用于并行流/流)
        Optional<Integer> any = list.parallelStream().filter(x -> x > 2).findAny();
        System.out.println(any.get());
    }

    @Test
    void demo04(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // 返回当前元素是否包含指定条件的元素
        boolean flag = list.stream().anyMatch(x -> x < 7);
        System.out.println(flag);
    }


}
