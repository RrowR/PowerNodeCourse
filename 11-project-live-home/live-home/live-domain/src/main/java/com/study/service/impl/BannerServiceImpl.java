package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.Banner;
import com.study.mapper.BannerMapper;
import com.study.service.BannerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService{

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<String> getBanner() {
//        List<String> paths = bannerMapper.selectBanner();
        // 另一种写法,给LambdaQueryWrapper设置条件从而单表不需要写sql
        List<Banner> banners = bannerMapper.selectList(new LambdaQueryWrapper<Banner>()
                .orderByDesc(Banner::getBeginTime)
                .last("limit 5")        // last是最后的语句
        );
        List<String> paths = banners.stream().map(Banner::getPath).collect(Collectors.toList());
        return paths;
    }
}
