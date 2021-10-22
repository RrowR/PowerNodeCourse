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

@ApiModel(value="com-study-domain-Comments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "comments")
public class Comments implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 用户名，即用户手机号
     */
    @TableField(value = "username")
    @ApiModelProperty(value="用户名，即用户手机号")
    private String username;

    /**
     * 评论内容
     */
    @TableField(value = "`comment`")
    @ApiModelProperty(value="评论内容")
    private String comment;

    /**
     * 评价星级
     */
    @TableField(value = "star")
    @ApiModelProperty(value="评价星级")
    private Integer star;

    /**
     * 房屋主键
     */
    @TableField(value = "houseId")
    @ApiModelProperty(value="房屋主键")
    private String houseid;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_COMMENT = "comment";

    public static final String COL_STAR = "star";

    public static final String COL_HOUSEID = "houseId";
}