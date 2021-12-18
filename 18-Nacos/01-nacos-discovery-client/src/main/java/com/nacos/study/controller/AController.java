package com.nacos.study.controller;

import com.nacos.study.feign.RpcFeign;
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

    @Autowired
    private RpcFeign rpcFeign;

    @GetMapping("rpc")
    public String doRpc(String serviceName){
        ServiceInstance instance = discoveryClient.getInstances(serviceName).get(0);
        int port = instance.getPort();
        String ip = instance.getHost();
        //String s = restTemplate.getForObject("http://" + ip + ":" + port + "hello", String.class);
        // 给 springweb包下的RestTemplate 设置LoadBalanced 可以不使用ip+port但是还是需要使用http作为远程调用请求
        String s = restTemplate.getForObject("http://" + serviceName + "/hello", String.class);
        return s;
    }

    @GetMapping("rpc2")
    public String doRpc2(){
        String result = rpcFeign.hello();
        return result;
    }

}
