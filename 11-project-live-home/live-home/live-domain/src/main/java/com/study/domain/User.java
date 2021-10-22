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

@ApiModel(value="com-study-domain-User")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User implements Serializable {
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
     * 注册时间
     */
    @TableField(value = "register_time")
    @ApiModelProperty(value="注册时间")
    private Date registerTime;

    /**
     * 最近登录时间
     */
    @TableField(value = "last_login_time")
    @ApiModelProperty(value="最近登录时间")
    private Date lastLoginTime;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 状态（0 禁用 1 正常）
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态（0 禁用 1 正常）")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_REGISTER_TIME = "register_time";

    public static final String COL_LAST_LOGIN_TIME = "last_login_time";

    public static final String COL_PASSWORD = "password";

    public static final String COL_STATUS = "status";
}