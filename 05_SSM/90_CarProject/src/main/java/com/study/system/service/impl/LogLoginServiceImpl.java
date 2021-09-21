package com.study.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.system.common.LogLoginDto;
import com.study.system.domain.LogLogin;
import com.study.system.mapper.LogLoginMapper;
import com.study.system.service.LogLoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogLoginServiceImpl implements LogLoginService{

    @Resource
    private LogLoginMapper logLoginMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return logLoginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LogLogin record) {
        return logLoginMapper.insert(record);
    }

    @Override
    public int insertSelective(LogLogin record) {
        return logLoginMapper.insertSelective(record);
    }

    @Override
    public LogLogin selectByPrimaryKey(Integer id) {
        return logLoginMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LogLogin record) {
        return logLoginMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LogLogin record) {
        return logLoginMapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<LogLogin> queryForPage(LogLoginDto logLoginDto) {
        // 使用PageHelper来切入分页查询的条件
        Page<LogLogin> page = PageHelper.startPage(logLoginDto.getPage(), logLoginDto.getLimit());
        List<LogLogin> logLoginList = logLoginMapper.queryForAllLogLogin(logLoginDto);
        // 返回的是一个被PageHelper切入的分页对象(原本是一个查询所有，被pageHelper切入成了一个分页查询)
        return page;
    }

    @Override
    @Transactional
    public void batchDelete(Integer[] ids) {
        if (ids != null && ids.length > 0){
            logLoginMapper.deleteBatch(ids);
        }
    }


}
