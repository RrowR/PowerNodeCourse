package com.study.mapper;

import com.study.domain.Items;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);
}