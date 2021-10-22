package com.study.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.mapper.HousesMapper;
import com.study.domain.Houses;
import com.study.service.HousesService;
@Service
public class HousesServiceImpl implements HousesService{

    @Resource
    private HousesMapper housesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return housesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Houses record) {
        return housesMapper.insert(record);
    }

    @Override
    public int insertSelective(Houses record) {
        return housesMapper.insertSelective(record);
    }

    @Override
    public Houses selectByPrimaryKey(Integer id) {
        return housesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Houses record) {
        return housesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Houses record) {
        return housesMapper.updateByPrimaryKey(record);
    }

}
