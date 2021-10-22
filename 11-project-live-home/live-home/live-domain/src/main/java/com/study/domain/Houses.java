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

@ApiModel(value="com-study-domain-Houses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Houses implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 房屋标题
    */
    @ApiModelProperty(value="房屋标题")
    private String title;

    /**
    * 房屋类型
    */
    @ApiModelProperty(value="房屋类型")
    private String houseType;

    /**
    * 租赁类型
    */
    @ApiModelProperty(value="租赁类型")
    private String rentType;

    /**
    * 价格
    */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
    * 城市
    */
    @ApiModelProperty(value="城市")
    private String city;

    /**
    * 主图多个图片使用,分割
    */
    @ApiModelProperty(value="主图多个图片使用,分割")
    private String imgs;

    /**
    * 房屋信息，例如years: "建造年份 2002年" type: "庭室  4室1厅", level: "楼层  17/19层",style: "装修  精装性",orientation: "朝向  朝南"
    */
    @ApiModelProperty(value="房屋信息，例如years: '建造年份 2002年' type: '庭室  4室1厅', level: '楼层  17/19层',style: '装修  精装性',orientation: '朝向  朝南'")
    private String info;

    /**
    * 购买时间
    */
    @ApiModelProperty(value="购买时间")
    private Date buyTime;

    /**
    * 数量
    */
    @ApiModelProperty(value="数量")
    private Integer nums;

    private static final long serialVersionUID = 1L;
}