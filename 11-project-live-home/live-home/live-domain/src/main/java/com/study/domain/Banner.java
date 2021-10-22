package com.study.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-study-domain-Banner")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 路径
    */
    @ApiModelProperty(value="路径")
    private String path;

    /**
    * 开始时间
    */
    @ApiModelProperty(value="开始时间")
    private Date beginTime;

    /**
    * 结束时间
    */
    @ApiModelProperty(value="结束时间")
    private Date endTime;

    private static final long serialVersionUID = 1L;
}