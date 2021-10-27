package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientProvider2 {
    public static void main(String[] args) {
        SpringApplication.run(ClientProvider2.class,args);
    }
}
