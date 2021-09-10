package com.study.mapper;


import com.study.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface StudentMapper {
    /*
        查询一个学生信息，包含其他班级信息，返回一个map
     */
    Map<String, Object> queryOneStudent1(@Param("id") Integer id);

    Student queryOneStudent2(@Param("id") Integer id);
}