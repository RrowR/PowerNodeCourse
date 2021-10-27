package com.study;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComsumerApplication.class, args);
    }


    @Bean
    @LoadBalanced       // 这个注解会让Ribbon来代理
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 往IOC容器中放入一个固定算法
     * 当前的消费者 去调用任何提供者都按照这个负载均衡算法实现
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
