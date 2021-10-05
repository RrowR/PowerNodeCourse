package com.study.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty(value = "用户的的id")
    private Integer id;
    @ApiModelProperty(value = "用户的的名称")
    private String name;
    @ApiModelProperty(value = "用户的的地址")
    private String address;
    @ApiModelProperty(value = "用户的的生日")
    private Date birth;
    @ApiModelProperty(value = "用户的的爱好")
    private List<String> hobby;
    @ApiModelProperty(value = "用户的的map")
    private Map<String, String> map;
}
