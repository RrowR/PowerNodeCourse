package com.study;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.bloomfilter.BloomFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpikeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpikeWebApplication.class, args);
    }

    @Bean
    public BloomFilter bloomFilter(){
        return new BitMapBloomFilter(10);
    }

}
