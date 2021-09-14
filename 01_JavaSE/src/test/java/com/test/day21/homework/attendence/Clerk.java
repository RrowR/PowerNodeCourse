package com.test.day21.homework.attendence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clerk {
    private String empId;
    private String empName;
    // 部门
    private String dept;
    // 电话
    private String phone;
}
