package com.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestDemo {
    @Test
    void MethodTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(10));
        }
    }

    @Test
    void Method02() {
        Stream.generate(() -> "Hello World!")
                .forEach(e -> System.out.println(e));
    }

    @Test
    void Method03() {
        // 所以这里直接可以引入一个没有参数的Math.random()方法，得到每一个随机数的值到stream流中
        Stream<Double> stream1 = Stream.generate(Math::random).limit(3);
        /* 上面等价于下面，生成一个无限流，流里面的数据是无数个随机数,
            而这个函数式接口是没有形参的，所以lambda里的参数为空，并且得到每一个随机数的值
            @FunctionalInterface
            public interface Supplier<T> {
                 * Gets a result.
                 * @return a result
                    T get();
                }
         */
        Stream<Double> stream2 = Stream.generate(() -> Math.random()).limit(3);
    }

    @Test
    void Method04() {
        int[] arrays = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arrays);
        stream.forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }
}
