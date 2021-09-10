package com.test;

import com.study.domain.Student;
import com.study.mapper.StudentMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Test_Associated_search {

    @Test
    void MethodSearchStudent1(){
        /*
            查询一条sql，将结果封装到map中，sql返回值参数有多少个，map就有多少个键值对
         */
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> student = mapper.queryOneStudent1(1);
        System.out.println(student);
    }

    @Test
    void MethodSearchStudent2(){
        /*
            将查询的结果封装到Student对象中
         */
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryOneStudent2(1);
        System.out.println(student);
    }

    @Test
    void MethodSearchStudent3(){
        /*
            将查询的结果封装到Student对象中
         */
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryOneStudent3(4);
        System.out.println(student);
    }

    @Test
    void MethodSearchStudent4(){
        /*
            测试级联查询
         */
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryOneStudent4(4);
        System.out.println(student);
    }
}
