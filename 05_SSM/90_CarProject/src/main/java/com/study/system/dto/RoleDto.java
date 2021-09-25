package com.study.system.dto;

import lombok.Data;

@Data
public class RoleDto extends BaseDto{
    private String rolename;

    private String roledesc;

    private Integer available;
}
