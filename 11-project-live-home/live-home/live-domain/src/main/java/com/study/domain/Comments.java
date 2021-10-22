package com.study.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-study-domain-Comments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comments implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 用户名，即用户手机号
    */
    @ApiModelProperty(value="用户名，即用户手机号")
    private String username;

    /**
    * 评论内容
    */
    @ApiModelProperty(value="评论内容")
    private String comment;

    /**
    * 评价星级
    */
    @ApiModelProperty(value="评价星级")
    private Integer star;

    /**
    * 房屋主键
    */
    @ApiModelProperty(value="房屋主键")
    private String houseid;

    private static final long serialVersionUID = 1L;
}