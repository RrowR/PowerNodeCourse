package com.study.demo10;

import com.study.demo10.entity.Student;

import java.util.Date;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao{
    @Override
    public int addStudent(Student student) {
        // 这里只能写? 不能写 '?' 否则会报错
        String sql = "insert into student(name,address,age,sex,birth) value (?,?,?,?,?)";
        /*
            这里很不建议丢对象进去，等下在BaseDao中取出来会非常地麻烦，不仅可能要强转，还会导致其他方法无法调用,破坏了程序的扩展性
            并且后面循环遍历param也相当的不对，和?个数不对应
         */
        String name = student.getName();
        String address = student.getAddress();
        Integer age = student.getAge();
        String sex = student.getSex();
        Date birth = student.getBirth();
        Object[] params = {name,address,age,sex,birth};
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
