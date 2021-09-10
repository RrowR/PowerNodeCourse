package com.study.mapper;


import com.study.domain.Classes;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    Classes queryClassesById(@Param("id") Integer id);

    Classes queryClassesWithStudentsById(@Param("id") Integer id);
}