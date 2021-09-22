package com.study.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class NewsDto extends BaseDto{
    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;
}
