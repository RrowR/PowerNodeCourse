package com.study.system.service;

import com.github.pagehelper.Page;
import com.study.system.domain.News;
import com.study.system.dto.NewsDto;

import java.util.List;

public interface NewsService{


    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    Page<News> queryForPage(NewsDto newsDto);

    void batchDelete(Integer[] ids);

    /*
        查询所有的新闻
     */
    List<News> queryAllNews();
}
