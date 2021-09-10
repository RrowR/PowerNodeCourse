package com.study.mapper;


import com.study.domain.Classes;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    public Classes queryClassesById(@Param("id") Integer id);
}