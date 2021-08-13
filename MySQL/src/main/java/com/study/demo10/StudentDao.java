package com.study.demo10;

import com.study.demo10.entity.Student;

import java.util.List;

public interface StudentDao {
    // 传入一个学生对象，插入一个学生，返回值是被影响的行数
    int addStudent(Student student);

    // 根据id删除一个学生，返回值是被影响的行数
    int deleteStudent(Integer id);

    // 根据id修改学生信息，返回的是被影响的行数
    int updateStudent(Student student);

    // 根据id查询一个学生，返回的是一个Studentn对象
    Student queryStudentById(Integer id);

    // 不需要Id查询所有学生，返回一个包含所有学生的学生集合
    List<Student> queryAllStudent();

}
