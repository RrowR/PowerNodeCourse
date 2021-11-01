package com.study.utils;

import com.study.domain.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
    模拟数据库
 */
public class DbUtils {
    private static HashMap<Integer, Goods> db = new HashMap<>();

    public static Integer add(Goods goods) {
        db.put(goods.getId(), goods);
        return goods.getId();
    }

    public static List<Goods> findGoodsByIds(Set<Integer> ids){
        ArrayList<Goods> goodsList = new ArrayList<>();
        ids.forEach(id -> {
            Goods goods = db.get(id);
            goodsList.add(goods);
        });
        return goodsList;
    }
}
