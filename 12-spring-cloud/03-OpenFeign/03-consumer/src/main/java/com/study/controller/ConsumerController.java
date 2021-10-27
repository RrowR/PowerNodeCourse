package com.study.controller;

import com.study.domain.Order;
import com.study.feign.ConsumerFeign;
import com.study.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerFeign consumerFeign;

    @GetMapping("feignmethod")
    public String consumerOrder(){
        String result = consumerFeign.doOrderkkk();
        System.out.println(result);
        return result;
    }

    @GetMapping("testParam")
    public String utlTest(){
        Result result = consumerFeign.urlTest(1);
        System.out.println(result);

        Result result1 = consumerFeign.oneParam("hhh");
        System.out.println(result1);

        Result result2 = consumerFeign.twoParam("hhh", 23);
        System.out.println(result2);

        Order order = new Order(123131,"牛扒",new Date(),true);
        Result result3 = consumerFeign.oneObj(order);
        System.out.println(result3);

        Result result4 = consumerFeign.oneObjOneParam(order, "xdxd");
        System.out.println(result4);

        return "ok";
    }

    @GetMapping("testParam2")
    public String getToList(){
        Result result = consumerFeign.oneList(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(result);
        return "ok";
    }

    @GetMapping("testTime")
    public String testTime(){
        Result result = consumerFeign.testTime(new Date());
        System.out.println(result);
        return "ok";
    }

    @GetMapping("testTime2")
    public String testTime2(){
        Result result = consumerFeign.testTime2(LocalDate.now());
        System.out.println(result);
        return "ok";
    }

    @GetMapping("testTime3")
    public String testTime3(){
        Result result = consumerFeign.testTime3(LocalDateTime.now());
        System.out.println(result);
        return "ok";
    }

}
