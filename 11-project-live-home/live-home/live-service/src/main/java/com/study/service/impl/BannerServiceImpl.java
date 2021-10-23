package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.study.constant.BannerConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.Banner;
import com.study.mapper.BannerMapper;
import com.study.service.BannerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = {"com.study.service.impl.BannerServiceImpl"})
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService{

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    @Cacheable(key = BannerConstant.Banner_CACHE_PREFIX)
    public List<String> getBanner() {
//        List<String> paths = bannerMapper.selectBanner();
        // 另一种写法,给LambdaQueryWrapper设置条件从而单表不需要写sql
//        List<Banner> banners = bannerMapper.selectList(new LambdaQueryWrapper<Banner>()
//                .orderByDesc(Banner::getBeginTime)
//                .last("limit 5")        // last是最后的语句
//        );
//
//        List<String> paths = banners.stream().map(Banner::getPath).collect(Collectors.toList());

        List<Object> objects = bannerMapper.selectObjs(new LambdaQueryWrapper<Banner>()
                .select(Banner::getPath)
                .orderByDesc(Banner::getBeginTime)
                .last("limit 5"));
        // 使用流的方法效率会非常快，给每一个对西那个进行toString
        List<String> paths = objects.stream().map(Object::toString).collect(Collectors.toList());

        return paths;
    }
}
