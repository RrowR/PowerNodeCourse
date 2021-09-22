package com.study.system.mapper;

import com.study.system.domain.News;
import com.study.system.dto.NewsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> queryAllNews(@Param("newsDto") NewsDto newsDto);
}