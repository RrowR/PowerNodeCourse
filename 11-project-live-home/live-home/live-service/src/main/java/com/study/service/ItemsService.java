package com.study.service;

import com.study.domain.Items;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ItemsService extends IService<Items>{


    List<Items> findHotProductOrRecommendation(String city, Integer type);
}
