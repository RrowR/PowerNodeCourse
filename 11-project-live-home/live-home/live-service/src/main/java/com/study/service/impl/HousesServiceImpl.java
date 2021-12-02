package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.mapper.HousesMapper;
import com.study.domain.Houses;
import com.study.service.HousesService;

import java.io.Serializable;
import java.util.List;

@Service
@CacheConfig(cacheNames = {"com.study.service.impl.HousesServiceImpl"})
public class HousesServiceImpl extends ServiceImpl<HousesMapper, Houses> implements HousesService {

    @Autowired
    private HousesMapper housesMapper;

    @Override
    public Page<Houses> searchHousePage(Integer page, String city, String content) {
        Page<Houses> housesPage = new Page<>(page, 5);
        Page<Houses> selectPage = housesMapper.selectPage(housesPage, new LambdaQueryWrapper<Houses>()
                .eq(Houses::getCity, city)
                .like(Houses::getTitle, content)
                .orderByAsc(Houses::getPrice)
        );
        List<Houses> housesList = selectPage.getRecords();
        // 处理房屋图片,只显示第一张
        housesList.forEach(houses -> {
            String imgs = houses.getImgs();
            if (imgs.contains(",")) {
                houses.setImgs(imgs.split(",")[0]);
            }
        });
        return selectPage;
    }

    @Override
    @Cacheable(key = "#id")
    public Houses getById(Serializable id) {
        Houses houses = housesMapper.selectById(id);
        // 因为info是一个字符串，所以要转成对象封装到自己创建的对象里
        Houses.HouseInfo houseInfo = JSON.parseObject(houses.getInfo(), Houses.HouseInfo.class);
        houses.setHouseInfo(houseInfo);
        return houses;
    }
}
