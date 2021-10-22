package com.study.domain;

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
public class User implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 手机号|用户名
    */
    @ApiModelProperty(value="手机号|用户名")
    private String username;

    /**
    * 注册时间
    */
    @ApiModelProperty(value="注册时间")
    private Date registerTime;

    /**
    * 最近登录时间
    */
    @ApiModelProperty(value="最近登录时间")
    private Date lastLoginTime;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 状态（0 禁用 1 正常）
    */
    @ApiModelProperty(value="状态（0 禁用 1 正常）")
    private Integer status;

    private static final long serialVersionUID = 1L;
}