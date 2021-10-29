package com.study.feign;


import domain.Order;
import com.study.feign.hystrix.UserOrderFeignHystrix;
import model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 创建一个接口
 * 加一个注解FeignClient（value = "order-service"） 写提供者的应用名称
 */
@FeignClient(value = "order-center", fallback = UserOrderFeignHystrix.class)
public interface UserOrderFeign {

    /**
     * 在这个feign接口里面 写提供者的方法签名（返回值 方法名 参数列表 注解...）
     *
     * @return
     */
    @GetMapping("doOrder")
    String doOrder();


    @GetMapping("urlTest/{id}")
    Result urlTest(@PathVariable("id") Integer id);


    @GetMapping("oneParam")
    Result oneParam(@RequestParam String name);


    /**
     * Method has too many Body parameters
     * 两个基本参数的时候 必须要加@RequestParam
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("twoParam")
    Result twoParam(@RequestParam String name, @RequestParam Integer age);

    @PostMapping("oneObj")
    Result oneObj(@RequestBody Order order);


    @PostMapping("oneObjOneParam")
    Result oneObjOneParam(@RequestBody Order order, @RequestParam String name);


    @GetMapping("getObj")
    Result getObj(@RequestParam List<Integer> ids);


    @GetMapping("testTime")
    Result testTime(@RequestParam Date date);


    @GetMapping("testTime2")
    public Result testTime2(@RequestParam LocalDate date);


    @GetMapping("testTime3")
    public Result testTime3(@RequestParam LocalDateTime localDateTime);

}
