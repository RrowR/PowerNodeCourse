package com.study.demo10;

import com.study.demo10.entity.Student;

import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao{
    @Override
    public int addStudent(Student student) {
        String sql = "insert into student(name,address,age,sex,birth) value ('?','?','?','?','?')";
        Object[] params = {student};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int deleteStudent(Integer id) {
        return 0;
    }

    @Override
    public int updateStudent(Student student) {

        return 0;
    }

    @Override
    public Student queryStudentById(Integer id) {
        Object[] params = {id};
        String sql = "select * from student where id = ?";
        return super.selectOne(sql,Student.class,params);
    }

    /*
        查询所有学生，返回一个List<Student>集合
     */
    @Override
    public List<Student> queryAllStudent() {
        String sql = "select * from student";
        Object[] params = null;
        // 核心就是调用BaseDao里的（selectList方法）去查询数据库，这个方法
        return super.selectList(sql,Student.class,params);      // 调用父类的selectList方法，返回一个List集合
    }
}
