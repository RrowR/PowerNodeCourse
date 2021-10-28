package com.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController extends BaseController{

    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("getFood")
    public String getFood() {
        String food = providerFeign.makeFood();
        System.out.println(food);
        return food;
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     * HystrixCommand   熔断方法
     * @param serviceName
     * @return
     */
    @GetMapping("testRibbonHystrix")
    @HystrixCommand(fallbackMethod = "testRibbonHystrixFallback")
    public String testRibbonHystrix(String serviceName) {
        String url = "http://" + serviceName + "/makeFood";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }



}
