package com.study.service;

import com.study.domain.Goods;

import java.util.List;

public interface GoodsService {
    void saveGoods(Goods goods);

    List<Goods> findGoodByKeyWords(String keyword);
}
