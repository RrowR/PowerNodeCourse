package com.test.day99finalTask.task05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @MyJsonUtils(reName = "名字")
    private String name;
    @MyJsonUtils(reName = "年龄")
    private Integer age;
}
