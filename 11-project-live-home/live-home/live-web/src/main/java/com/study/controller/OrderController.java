package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.common.Result;
import com.study.domain.Order;
import com.study.service.CommentsService;
import com.study.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "订单管理接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommentsService commentsService;

    @GetMapping("order")
    @ApiOperation("获取用户订单列表")
    public Result<List<Order>> findOrderById() {
        // 1.获取当前用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JSONObject jsonObject = JSON.parseObject(authentication.getPrincipal().toString());
        String userId = jsonObject.get("username").toString();
        List<Order> orderList = orderService.findOrdersById(userId);
        return Result.success("ok", orderList);
    }

    @PostMapping("feelback")
    public Result<String> feelback(String rate, String feelback, String orderId) {
        commentsService.saveComm(rate,feelback,orderId);
        return Result.success("评论成功","评价成功");
    }

}
