package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ComsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    /**
     *  http://localhost:8082/testlb?serviceName=provider-01
     * @param serviceName       使用get方法必须给赋值
     * @return
     */
    @GetMapping("testlb")
    public String testLocalBalance(String serviceName){
        // 从eureka里获取实例对象(spring.application.name来获取provider实例)
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://"+host+":"+port+"/pro";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }
}
