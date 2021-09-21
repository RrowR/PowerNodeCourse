package com.study.system.mapper;

import com.study.system.common.LogLoginDto;
import com.study.system.domain.LogLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogLogin record);

    int insertSelective(LogLogin record);

    LogLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogLogin record);

    int updateByPrimaryKey(LogLogin record);

    List<LogLogin> queryForAllLogLogin(@Param("logLoginDto") LogLoginDto logLoginDto);

    void deleteBatch(@Param("ids") Integer[] ids);
}