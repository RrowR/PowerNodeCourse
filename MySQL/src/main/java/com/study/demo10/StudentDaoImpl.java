package com.study.demo10;

import com.study.demo10.entity.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao{
    @Override
    public Student queryStudentById(Integer id) {
        Object[] params = {id};
        String sql = "select * from student where id = ?";
        return super.selectOne(sql,Student.class,params);
    }
}
