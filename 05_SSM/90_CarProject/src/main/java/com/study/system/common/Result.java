package com.study.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code=0;//业务码
    private String msg="";// 业务消息
    private Integer count=0;//数据总条数[对layui的table分页有效果]
    private Object data;// 业务数据

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String msg, Integer count, Object data) {
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
