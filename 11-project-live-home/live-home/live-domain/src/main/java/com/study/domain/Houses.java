package com.study.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="com-study-domain-Houses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "houses")
public class Houses implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 房屋标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="房屋标题")
    private String title;

    /**
     * 房屋类型
     */
    @TableField(value = "house_type")
    @ApiModelProperty(value="房屋类型")
    private String houseType;

    /**
     * 租赁类型
     */
    @TableField(value = "rent_type")
    @ApiModelProperty(value="租赁类型")
    private String rentType;

    /**
     * 价格
     */
    @TableField(value = "price")
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 城市
     */
    @TableField(value = "city")
    @ApiModelProperty(value="城市")
    private String city;

    /**
     * 主图多个图片使用,分割
     */
    @TableField(value = "imgs")
    @ApiModelProperty(value="主图多个图片使用,分割")
    private String imgs;

    /**
     * 房屋信息，例如years: "建造年份 2002年" type: "庭室  4室1厅", level: "楼层  17/19层",style: "装修  精装性",orientation: "朝向  朝南"
     */
    @TableField(value = "info")
    @ApiModelProperty(value="房屋信息，例如years: '建造年份 2002年' type: '庭室  4室1厅', level: '楼层  17/19层',style: '装修  精装性',orientation: '朝向  朝南'")
    private String info;

    /**
     * 购买时间
     */
    @TableField(value = "buy_time")
    @ApiModelProperty(value="购买时间")
    private Date buyTime;

    /**
     * 数量
     */
    @TableField(value = "nums")
    @ApiModelProperty(value="数量")
    private Integer nums;

    @TableField(exist = false)
    @ApiModelProperty(value="房屋对象信息")
    private HouseInfo houseInfo;

    @Data
    @ApiModel("房屋信息对象")
    public static class HouseInfo{
        @ApiModelProperty("年份")
        private String years;
        @ApiModelProperty("类型")
        private String type;
        @ApiModelProperty("级别")
        private String level;
        @ApiModelProperty("风格")
        private String style;
        @ApiModelProperty("朝向")
        private String orientation;
    }
}