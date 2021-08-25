package com.test.day99finalTask.task02;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransRecord {
    @JSONField(ordinal = 1)
    private int id;
    @JSONField(ordinal = 2)
    private String name;
    @JSONField(ordinal = 3)
    private String code;
    @JSONField(ordinal = 4)
    private String sex;
    @JSONField(ordinal = 5)
    private String account;
    @JSONField(ordinal = 6)
    private Date createtime;
    @JSONField(ordinal = 7)
    private Double money;
}
