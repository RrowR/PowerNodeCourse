package com.study.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "`order`")
public class Order implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 订单号
     */
    @TableField(value = "order_num")
    @ApiModelProperty(value="订单号")
    private String orderNum;

    /**
     * 房屋标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="房屋标题")
    private String title;

    /**
     * 房屋类型， 厅室 - 面积
     */
    @TableField(value = "house_type")
    @ApiModelProperty(value="房屋类型， 厅室 - 面积")
    private String houseType;

    /**
     * 价格
     */
    @TableField(value = "price")
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 图片
     */
    @TableField(value = "img")
    @ApiModelProperty(value="图片")
    private String img;

    /**
     * 租赁方式
     */
    @TableField(value = "rent_type")
    @ApiModelProperty(value="租赁方式")
    private String rentType;

    /**
     * 评论标记。 0 - 未评论。 2 - 已评论
     */
    @TableField(value = "comment_state")
    @ApiModelProperty(value="评论标记。 0 - 未评论。 2 - 已评论")
    private Integer commentState;

    /**
     * 房屋主键
     */
    @TableField(value = "house_id")
    @ApiModelProperty(value="房屋主键")
    private Integer houseId;

    /**
     * 用户id
     */
    @TableField(value = "`user`")
    @ApiModelProperty(value="用户id")
    private Integer user;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 用户手机号
     */
    @TableField(value = "user_phone")
    @ApiModelProperty(value="用户手机号")
    private String userPhone;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ORDER_NUM = "order_num";

    public static final String COL_TITLE = "title";

    public static final String COL_HOUSE_TYPE = "house_type";

    public static final String COL_PRICE = "price";

    public static final String COL_IMG = "img";

    public static final String COL_RENT_TYPE = "rent_type";

    public static final String COL_COMMENT_STATE = "comment_state";

    public static final String COL_HOUSE_ID = "house_id";

    public static final String COL_USER = "user";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_USER_PHONE = "user_phone";
}