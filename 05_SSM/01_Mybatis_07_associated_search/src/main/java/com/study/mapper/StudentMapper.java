package com.study.mapper;


import com.study.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /*
        查询一个学生信息，包含其他班级信息，返回一个map
     */
    Map<String, Object> queryOneStudent1(@Param("id") Integer id);

    Student queryOneStudent2(@Param("id") Integer id);

    Student queryOneStudent3(@Param("id") Integer id);

    Student queryOneStudent4(@Param("id") Integer id);

    // 这里返回值没写集合居然在根据cid查询学生的时候也返回的是一个集合，（神奇），可能是collection标签的原因把
    List<Student> queryStudentByClassCid(@Param("cid") Integer cid);
}