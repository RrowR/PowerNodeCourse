package com.study.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole implements Serializable {
    private Integer id;

    private Integer roleid;

    private String rolename;

    private static final long serialVersionUID = 1L;
}