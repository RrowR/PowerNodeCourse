package com.study.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 商品
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "goods")
public class Goods implements Serializable {
    /**
     * 商品ID
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 商品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 现价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 详细描述
     */
    @TableField(value = "content")
    private String content;

    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 总库存
     */
    @TableField(value = "total_stocks")
    private Integer totalStocks;

    /**
     * 录入时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 是否参与秒杀1是0否
     */
    @TableField(value = "spike")
    private Integer spike;

    private static final long serialVersionUID = 1L;

    public static final String COL_GOODS_ID = "goods_id";

    public static final String COL_GOODS_NAME = "goods_name";

    public static final String COL_PRICE = "price";

    public static final String COL_CONTENT = "content";

    public static final String COL_STATUS = "status";

    public static final String COL_TOTAL_STOCKS = "total_stocks";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_SPIKE = "spike";
}