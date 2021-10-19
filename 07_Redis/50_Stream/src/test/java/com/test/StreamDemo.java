package com.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    @Test
    void createStreamMethods01(){
        // 1、通过 java.util.Collection.stream() 方法用集合创建流
        List<String> list = Arrays.asList("a", "v", "c");
        // 创建一个顺序流
        Stream<String> stream = list.stream();
        // 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();


    }

    @Test
    void createStreamMethods02(){
        // 2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] arrays = {1,2,3,4,5,6};
        Arrays.stream(arrays);
    }

    @Test
    void createStreamMethods03(){
        // 3.使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        stream.forEach(System.out::println);
        System.out.println("-------------------------------");
        /*
            seed – the initial element
            f – a function to be applied to to the previous element to produce a new element
         */
        Stream<Integer> stream1 = Stream.iterate(1, x -> x + 3).limit(4);
        stream1.forEach(System.out::println);

        // 这里可以传入接口的实现，也可以传入方法的引用
        Stream<Double> stream2 = Stream.generate(Math::random).limit(3);
        stream2.forEach(System.out::println);
    }

    @Test
    void streamToparallelStream(){
        Stream<Integer> stream = Stream.of(1, 5, 2, 4, 6, 8, 9, 11, 22, 15, 24, 12);
        Optional<Integer> optional = stream.parallel().filter(a -> a > 11).findFirst();
        Stream<Integer> stream1 = stream.parallel().filter(a -> a > 11);
        stream1.forEach(System.out::println);
        System.out.println(optional.get());

    }
}
