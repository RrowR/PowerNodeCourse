package com.test;

import com.study.domain.Classes;
import com.study.domain.Student;
import com.study.mapper.ClassesMapper;
import com.study.mapper.StudentMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
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

    @Test
    void MethodSearchClassesThenStudents1(){
        /*
            测试级联查询,先查询课程表，再在配置文件中根据课程表的cid去调用查询学生表（根据cid去查学生）
         */
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
        Classes classes = mapper.queryClassesWithStudentsById(1);
        System.out.println("classes = " + classes);
    }

    @Test
    void MethodSearchClassesThenStudents2(){
        /*
            我们先查询所有课程，但是课程的学生集合是空的
            然后根据课程的id去查询对应学生的cid找到所有学生集合
            再将集合设置到课程中去即可
         */
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 先查询所有的课程
        Classes classes = classesMapper.queryClassesById(1);
        // 在根据课程的id号去查询所有对应课程的学生
        List<Student> students = studentMapper.queryStudentByClassCid(classes.getId());
        // 再将所有学生添加到对应的课程中
        classes.setStudents(students);
        System.out.println("classes = " + classes);

    }
}
