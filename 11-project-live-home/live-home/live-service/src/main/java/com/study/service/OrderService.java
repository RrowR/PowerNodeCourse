package com.study.service;

import com.study.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OrderService extends IService<Order>{


    List<Order> findOrdersById(String userId);
}
