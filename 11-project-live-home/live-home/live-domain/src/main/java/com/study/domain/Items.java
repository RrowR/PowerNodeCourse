package com.study.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "items")
public class Items implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 条目标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="条目标题")
    private String title;

    /**
     * 图片
     */
    @TableField(value = "img")
    @ApiModelProperty(value="图片")
    private String img;

    /**
     * 销售数量
     */
    @TableField(value = "sales")
    @ApiModelProperty(value="销售数量")
    private Long sales;

    /**
     * 是否推荐
     */
    @TableField(value = "recommendation")
    @ApiModelProperty(value="是否推荐")
    private Boolean recommendation;

    /**
     * 推荐排序
     */
    @TableField(value = "recommendation_sort")
    @ApiModelProperty(value="推荐排序")
    private Integer recommendationSort;

    /**
     * 城市
     */
    @TableField(value = "city")
    @ApiModelProperty(value="城市")
    private String city;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_TITLE = "title";

    public static final String COL_IMG = "img";

    public static final String COL_SALES = "sales";

    public static final String COL_RECOMMENDATION = "recommendation";

    public static final String COL_RECOMMENDATION_SORT = "recommendation_sort";

    public static final String COL_CITY = "city";
}