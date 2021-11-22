package com.nacos.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("rpc")
    public String doRpc(String serviceName){
        ServiceInstance instance = discoveryClient.getInstances(serviceName).get(0);
        int port = instance.getPort();
        String ip = instance.getHost();
        String s = restTemplate.getForObject("http://" + ip + ":" + port + "hello", String.class);
        return s;
    }

}
