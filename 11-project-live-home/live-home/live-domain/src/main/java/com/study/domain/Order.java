package com.study.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-study-domain-Order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 订单号
    */
    @ApiModelProperty(value="订单号")
    private String orderNum;

    /**
    * 房屋标题
    */
    @ApiModelProperty(value="房屋标题")
    private String title;

    /**
    * 房屋类型， 厅室 - 面积
    */
    @ApiModelProperty(value="房屋类型， 厅室 - 面积")
    private String houseType;

    /**
    * 价格
    */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
    * 图片
    */
    @ApiModelProperty(value="图片")
    private String img;

    /**
    * 租赁方式
    */
    @ApiModelProperty(value="租赁方式")
    private String rentType;

    /**
    * 评论标记。 0 - 未评论。 2 - 已评论
    */
    @ApiModelProperty(value="评论标记。 0 - 未评论。 2 - 已评论")
    private Integer commentState;

    /**
    * 房屋主键
    */
    @ApiModelProperty(value="房屋主键")
    private Integer houseId;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Integer user;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 用户手机号
    */
    @ApiModelProperty(value="用户手机号")
    private String userPhone;

    private static final long serialVersionUID = 1L;
}