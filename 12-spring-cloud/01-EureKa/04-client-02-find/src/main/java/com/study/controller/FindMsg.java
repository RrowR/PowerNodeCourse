package com.study.controller;

import com.netflix.discovery.converters.Auto;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FindMsg {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("client02msg")
    public String client02Msg(String serviceName){
        // 根据应用名字发现实例
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        // 获得这个实例对象，可能有多个
        ServiceInstance instance = instances.get(0);
        System.out.println(instance);
        // 获得实例的host
        String ip = instance.getHost();
        System.out.println(ip);
        // 获得实例的port
        int port = instance.getPort();
        System.out.println(port);
        // 在这里发送一个http请求
        String url = "http://" + ip + ":" + port + "/clientmsg";
        String result = restTemplate.getForObject(url, String.class);

        System.out.println(result);
        return result;

    }
}
