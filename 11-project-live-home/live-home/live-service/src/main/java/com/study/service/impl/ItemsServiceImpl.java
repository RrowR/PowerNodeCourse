package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.mapper.ItemsMapper;
import com.study.domain.Items;
import com.study.service.ItemsService;

import java.util.List;

@Service
@Slf4j
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemsService{

    @Autowired
    private ItemsMapper itemsMapper;

    /**
     *
     * @param city  城市
     * @param type  热门标识  0 热门  1 推荐
     * @return
     */
    @Override
    public List<Items> findHotProductOrRecommendation(String city, Integer type) {
        log.info("查询{}城市的{}商品",city,type == 0 ? "热门" : "推荐");
        List<Items> itemsList = itemsMapper.selectList(new LambdaQueryWrapper<Items>()
                .eq(Items::getCity, city)    // where city = #{city}
                .orderByDesc(type == 0, Items::getSales)  // <if test = 'type=0'> order by sales </if>
                .orderByDesc(type == 1, Items::getSales)
                .last("limit 4"));
        return itemsList;
    }
}
