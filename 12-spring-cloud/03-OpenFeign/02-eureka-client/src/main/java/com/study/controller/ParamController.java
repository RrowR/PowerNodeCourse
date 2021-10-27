package com.study.controller;

import com.study.domain.Order;
import com.study.model.Result;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class ParamController {
    @GetMapping("urlTest/{id}")
    public Result urlTest(@PathVariable("id") Integer id) {
        System.out.println(id);
        return Result.success(200, "ok", id);
    }


    @GetMapping("oneParam")
    public Result oneParam(@RequestParam String name) {
        System.out.println(name);
        return Result.success(200, "ok", name);
    }


    @GetMapping("twoParam")
    public Result twoParam(@RequestParam String name, @RequestParam Integer age) {
        System.out.println(name);
        System.out.println(age);
        return Result.success(200, "ok", name);
    }

    @PostMapping("oneObj")
    public Result oneObj(@RequestBody Order order) {
        System.out.println(order);
        return Result.success(200, "ok", order);
    }


    // tips: 当传的是一个参数的时候 @RequestParam provider可以不加注解，但是当传的是一个对象的时候，服务端必须加@RequestBody注解
    @PostMapping("oneObjOneParam")
    public Result oneObjOneParam(@RequestBody Order order, @RequestParam String name) {
        System.out.println(order);
        System.out.println(name);
        return Result.success(200, "ok", order);
    }

    @GetMapping("getObj")
    public Result oneList(@RequestParam List<Integer> ids) {
        System.out.println(ids);
        return Result.success(200, "ok", ids);
    }

    @GetMapping("testTime")
    public Result testTime(@RequestParam Date date){
        System.out.println(date);
        return Result.success(200,"ok",date);
    }

    @GetMapping("testTime2")
    public Result testTime2(@RequestParam LocalDate date){
        System.out.println(date);
        return Result.success(200,"ok",date);
    }

    @GetMapping("testTime3")
    public Result testTime3(@RequestParam LocalDateTime date){
        System.out.println(date);
        return Result.success(200,"ok",date);
    }

}
