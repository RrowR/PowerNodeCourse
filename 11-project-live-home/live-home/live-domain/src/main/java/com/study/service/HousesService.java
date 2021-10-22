package com.study.service;

import com.study.domain.Houses;
public interface HousesService{


    int deleteByPrimaryKey(Integer id);

    int insert(Houses record);

    int insertSelective(Houses record);

    Houses selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Houses record);

    int updateByPrimaryKey(Houses record);

}
