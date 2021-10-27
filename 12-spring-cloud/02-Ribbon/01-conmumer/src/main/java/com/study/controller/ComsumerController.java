package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
public class ComsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    private Random random = new Random();

    private int num = 0;

    // 这个是ribbon依赖里的
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * http://localhost:8082/testlb?serviceName=provider-01
     *
     * @param serviceName 使用get方法必须给赋值
     * @return
     */
    @GetMapping("testlb")
    public String testLocalBalance(String serviceName) {
        // 从eureka里获取实例对象(spring.application.name来获取provider实例)
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        // 注意，当有2个provider的时候(服务名必须一样),这个实例也会有2个
        System.out.println(instances.size());
        ServiceInstance instance = instances.get(loadBalance(instances.size()));
        String host = instance.getHost();
        System.out.println(host);
        int port = instance.getPort();
        System.out.println(port);
        String url = "http://" + host + ":" + port + "/pro";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

    /**
     * ribbon怎么实现的？
     * 1.拦截这次请求
     * 2.截取出url中的主机名称
     * 3.借助eureka来做服务发现
     * 4.通过自己的负载均衡算法 获取一个符合的服务
     * 5.重构url地址
     * 6.在发起请求
     */

    @GetMapping("ribbon")
    public String RibbonLB(String ServiceName) {
        String url = "http://" + ServiceName + "/pro";
        // 给restTemplate加@Balanced之后，会对restTemplate进行增强，修改restTemplate的请求方法
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("choose")
    public Object testLocalBalance2(String serviceName) {
        // 使用ribbon的负载均衡来动态地返回instance实例
        ServiceInstance instance = loadBalancerClient.choose(serviceName);
        System.out.println(instance.getHost());
        System.out.println(instance.getPort());
        return instance;
    }

    private int loadBalance(int size) {
        // 轮询
        int x = num++ % size;
        return x;
    }

    private int loadBalance2(int size) {
        // 随机
        int x = random.nextInt(size);
        return x;
    }


}
