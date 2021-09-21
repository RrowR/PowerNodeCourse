package com.study.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogLogin {
    private Integer id;

    private String loginname;

    private String loginip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date logintime;
}