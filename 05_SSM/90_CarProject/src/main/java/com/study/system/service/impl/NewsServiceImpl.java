package com.study.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.system.domain.News;
import com.study.system.dto.NewsDto;
import com.study.system.mapper.NewsMapper;
import com.study.system.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Resource
    private NewsMapper newsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(News record) {
        return newsMapper.insert(record);
    }

    @Override
    public int insertSelective(News record) {
        return newsMapper.insertSelective(record);
    }

    @Override
    public News selectByPrimaryKey(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(News record) {
        return newsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(News record) {
        return newsMapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<News> queryForPage(NewsDto newsDto) {
        // pagehleper会先进行切面
        Page<News> page = PageHelper.startPage(newsDto.getPage(), newsDto.getLimit());
        // 这里直接查询所有即可
        List<News> newsList = newsMapper.queryAllNews(newsDto);
        return page;
    }

}
