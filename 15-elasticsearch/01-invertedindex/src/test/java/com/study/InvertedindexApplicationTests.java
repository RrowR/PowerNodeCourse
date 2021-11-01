package com.study;

import com.study.domain.Goods;
import com.study.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class InvertedindexApplicationTests {

    @Autowired
    private GoodsService goodsService;

    @Test
    void contextLoads() {
        goodsService.saveGoods(new Goods(1,"苹果手机",5999D));
        goodsService.saveGoods(new Goods(2,"华为手机",3999D));
        goodsService.saveGoods(new Goods(3,"黑莓手机",9999D));
        goodsService.saveGoods(new Goods(4,"魅族手机",1999D));
        goodsService.saveGoods(new Goods(5,"锤子手机",2999D));

        List<Goods> goodsList = goodsService.findGoodByKeyWords("手机");
        System.out.println(goodsList);
    }

}
