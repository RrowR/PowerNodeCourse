package com.study.controller;

import domain.Order;
import com.study.feign.UserOrderFeign;
import model.Result;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController implements UserOrderFeign {


    /**
     * 实现别的模块里的 UserOrderFeign 接口去调用 order-center 实例里的方法
     * 在这个feign接口里面 写提供者的方法签名（返回值 方法名 参数列表 注解...）
     *
     * @return
     */
    @Override
    public String doOrder() {
        return "蛋炒饭";
    }

    @Override
    public Result urlTest(Integer id) {
        return null;
    }

    @Override
    public Result oneParam(String name) {
        return null;
    }

    /**
     * Method has too many Body parameters
     * 两个基本参数的时候 必须要加@RequestParam
     *
     * @param name
     * @param age
     * @return
     */
    @Override
    public Result twoParam(String name, Integer age) {
        return null;
    }

    @Override
    public Result oneObj(Order order) {
        return null;
    }

    @Override
    public Result oneObjOneParam(Order order, String name) {
        return null;
    }

    @Override
    public Result getObj(List<Integer> ids) {
        return null;
    }

    @Override
    public Result testTime(Date date) {
        return null;
    }

    @Override
    public Result testTime2(LocalDate date) {
        return null;
    }

    @Override
    public Result testTime3(LocalDateTime localDateTime) {
        return null;
    }
}
