package com.study.mapper;

import com.study.domain.Banner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}