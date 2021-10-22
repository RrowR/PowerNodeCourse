package com.study.mapper;

import com.study.domain.Houses;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HousesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Houses record);

    int insertSelective(Houses record);

    Houses selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Houses record);

    int updateByPrimaryKey(Houses record);
}