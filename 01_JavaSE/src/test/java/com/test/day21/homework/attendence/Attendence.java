package com.test.day21.homework.attendence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
    考勤类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendence {
    private String empId;
    // 打卡日期
    private LocalDate attDate;
    // 签到时间
    private LocalDate signInTime;
    // 签退时间
    private LocalDate signOutTime;
}
