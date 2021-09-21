package com.study.system.common;

import lombok.Data;

@Data
public class BaseDto {
    //封装 分页参数 的 BaseDto
    private Integer page;
    private Integer limit;
}
