package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.study.mapper"})
@EnableScheduling
public class SpikeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpikeServiceApplication.class, args);
    }

}
