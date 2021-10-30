package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootService03Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootService03Application.class,args);
    }
}
