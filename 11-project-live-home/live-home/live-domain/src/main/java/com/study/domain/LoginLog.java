package com.study.domain;

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
public class LoginLog implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 手机号|用户名
    */
    @ApiModelProperty(value="手机号|用户名")
    private String username;

    /**
    * 当前时间
    */
    @ApiModelProperty(value="当前时间")
    private Date createTime;

    /**
    * 登录方式:验证码|密码
    */
    @ApiModelProperty(value="登录方式:验证码|密码")
    private String type;

    /**
    * 消息
    */
    @ApiModelProperty(value="消息")
    private String message;

    /**
    * 登录状态 ： 1:成功|0:失败
    */
    @ApiModelProperty(value="登录状态 ： 1:成功|0:失败")
    private Integer status;

    private static final long serialVersionUID = 1L;
}