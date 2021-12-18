package com.study.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.constant.RentHouseConstant;
import com.study.domain.Houses;
import com.study.domain.Order;
import com.study.mapper.HousesMapper;
import com.study.mapper.OrderMapper;
import com.study.model.RentHouse;
import com.study.service.HousesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Service
@CacheConfig(cacheNames = {"com.study.service.impl.HousesServiceImpl"})
@Slf4j
public class HousesServiceImpl extends ServiceImpl<HousesMapper, Houses> implements HousesService {

    @Autowired
    private HousesMapper housesMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Page<Houses> searchHousePage(Integer page, String city, String content) {
        Page<Houses> housesPage = new Page<>(page, 5);
        Page<Houses> selectPage = housesMapper.selectPage(housesPage, new LambdaQueryWrapper<Houses>()
                .eq(Houses::getCity, city)
                .ne(Houses::getNums, 0)
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
    @Transactional(rollbackFor = RuntimeException.class)
    public void rentHouse(RentHouse rentHouse) {
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(RentHouseConstant.RENT_PREFIX + rentHouse.getHouseId(), "", Duration.ofSeconds(20));
        if (flag) {
            try {
                Integer houseId = rentHouse.getHouseId();
                String userId = rentHouse.getUserId();
                // 查询出房间号对应的字段
                Houses houses = housesMapper.selectById(houseId);
                int i = houses.getNums() - 1;
                if (i < 0) {
                    log.info("房屋{}已经被租完了", houseId);
                    return;
                }
                // 走到这一步说明没有被租完
                houses.setNums(i);
                // 更新库存
                housesMapper.updateById(houses);
                writerOrder(houseId, userId, houses);
            } finally {
                // 不需要自旋，因为只有1个房屋
                stringRedisTemplate.delete(RentHouseConstant.RENT_PREFIX + rentHouse.getHouseId());
            }
        }
    }

    public void writerOrder(Integer houseId, String userId, Houses houses) {
        // 使用❄️算法生成订单id
        String orderNum = IdUtil.getSnowflake(0, 0).nextIdStr();
        // 写订单表
        orderMapper.insert(Order.builder()
                .houseId(houseId)
                .id(Integer.valueOf(userId))
                .houseType("整租")
                .commentState(0)
                .img(houses.getImgs())
                .createTime(new Date())
                .title(houses.getTitle())
                .price(houses.getPrice())
                .orderNum(orderNum)
                .build());
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
