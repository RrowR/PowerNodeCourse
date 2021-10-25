package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Cluster1Application {

    public static void main(String[] args) {
        SpringApplication.run(Cluster1Application.class, args);
    }

}
