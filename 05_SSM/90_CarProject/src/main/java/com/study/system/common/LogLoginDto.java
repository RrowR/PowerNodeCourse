package com.study.system.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/*
    LogLoginDto里面有 登陆名字 登陆ip 登陆开始时间 结束时间
    里面有部分数据就是数据库对象LogLogin里的属性
    提出了公共页面(分页数据BaseDto)
 */
@Data
public class LogLoginDto extends BaseDto{

    private String loginname;

    private String loginip;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;

}
