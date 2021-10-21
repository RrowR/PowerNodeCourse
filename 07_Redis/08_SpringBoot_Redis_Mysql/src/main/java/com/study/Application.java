package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = {"com.study.mapper"})
@EnableCaching      // 开启注解缓存
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
