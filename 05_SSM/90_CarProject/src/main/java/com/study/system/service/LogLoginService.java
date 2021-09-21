package com.study.system.service;

import com.github.pagehelper.Page;
import com.study.system.domain.LogLogin;
import com.study.system.dto.LogLoginDto;
public interface LogLoginService{

    int deleteByPrimaryKey(Integer id);

    int insert(LogLogin record);

    int insertSelective(LogLogin record);

    LogLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogLogin record);

    int updateByPrimaryKey(LogLogin record);

    /*
        分页查询
     */
    Page<LogLogin> queryForPage(LogLoginDto logLoginDto);

    /*
        批量删除
     */
    void batchDelete(Integer[] ids);
}
