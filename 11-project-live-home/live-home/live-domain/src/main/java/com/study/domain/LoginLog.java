package com.study.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-study-domain-LoginLog")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "login_log")
public class LoginLog implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 手机号|用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value="手机号|用户名")
    private String username;

    /**
     * 当前时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="当前时间")
    private Date createTime;

    /**
     * 登录方式:验证码|密码
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value="登录方式:验证码|密码")
    private String type;

    /**
     * 消息
     */
    @TableField(value = "message")
    @ApiModelProperty(value="消息")
    private String message;

    /**
     * 登录状态 ： 1:成功|0:失败
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="登录状态 ： 1:成功|0:失败")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_TYPE = "type";

    public static final String COL_MESSAGE = "message";

    public static final String COL_STATUS = "status";
}