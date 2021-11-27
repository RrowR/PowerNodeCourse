package com.study;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ComsumerApp.class, args);
    }

    @Bean
    public BitMapBloomFilter bitMapBloomFilter(){
        return new BitMapBloomFilter(100);
    }

}
