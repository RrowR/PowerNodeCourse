package com.study.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.domain.Banner;
import com.study.mapper.BannerMapper;
import com.study.service.BannerService;
@Service
public class BannerServiceImpl implements BannerService{

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return bannerMapper.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerMapper.updateByPrimaryKey(record);
    }

}
