package com.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderSn;
    private String desc;
    private Date time;
    private Boolean flag;
}
