package com.study.common;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Api("返回结果")
public class Result<T> {

    public Integer code = 200;
    public String msg;
    public T data;


    public static <T> Result<T> success(String msg, T data) {
        Result result = new Result();
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
