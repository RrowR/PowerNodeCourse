package com.study.demo10;

import com.study.demo10.entity.Student;

public interface StudentDao {
    Student queryStudentById(Integer id);
}
