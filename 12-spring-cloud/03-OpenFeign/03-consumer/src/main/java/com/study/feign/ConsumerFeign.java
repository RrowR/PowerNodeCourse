package com.study.feign;

import com.study.domain.Order;
import com.study.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@FeignClient(value = "client-provider")         // 找到对应的服务名
public interface ConsumerFeign {

    @GetMapping("ordered")          // 找到服务名下对应的接口
    String doOrderkkk();            // 方法名可以随便取，给其他调用就可以了

    @GetMapping("urlTest/{id}")
    Result urlTest(@PathVariable("id") Integer id);


    @GetMapping("oneParam")
    Result oneParam(@RequestParam String name);


    @GetMapping("twoParam")
    Result twoParam(@RequestParam String name, @RequestParam Integer age);

    @PostMapping("oneObj")
    Result oneObj( Order order);


    @PostMapping("oneObjOneParam")
    Result oneObjOneParam(@RequestBody Order order, @RequestParam String name);

    @GetMapping("getObj")
    Result oneList(@RequestParam List<Integer> ids);

    @GetMapping("testTime")
    Result testTime(@RequestParam Date date);

    @GetMapping("testTime2")
    Result testTime2(@RequestParam LocalDate date);

    @GetMapping("testTime3")
    Result testTime3(@RequestParam LocalDateTime date);
}
