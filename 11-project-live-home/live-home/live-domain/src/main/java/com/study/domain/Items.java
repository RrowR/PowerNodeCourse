package com.study.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-study-domain-Items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Items implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 条目标题
    */
    @ApiModelProperty(value="条目标题")
    private String title;

    /**
    * 图片
    */
    @ApiModelProperty(value="图片")
    private String img;

    /**
    * 销售数量
    */
    @ApiModelProperty(value="销售数量")
    private Long sales;

    /**
    * 是否推荐
    */
    @ApiModelProperty(value="是否推荐")
    private Boolean recommendation;

    /**
    * 推荐排序
    */
    @ApiModelProperty(value="推荐排序")
    private Integer recommendationSort;

    /**
    * 城市
    */
    @ApiModelProperty(value="城市")
    private String city;

    private static final long serialVersionUID = 1L;
}