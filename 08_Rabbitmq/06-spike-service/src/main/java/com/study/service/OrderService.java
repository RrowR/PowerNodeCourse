package com.study.service;

import com.study.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
public interface OrderService extends IService<Order>{


    void doSpike(Integer userId, Integer goodsId);
}
