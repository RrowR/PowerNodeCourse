package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.Order;
import com.study.mapper.OrderMapper;
import com.study.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findOrdersById(String userId) {
        List<Order> orderList = orderMapper.selectList(new LambdaQueryWrapper<Order>()
                .eq(Order::getUser, userId)
        );

        for (Order order : orderList) {
            order.setImg(order.getImg().split(",")[0]);
        }
        return orderList;
    }
}
