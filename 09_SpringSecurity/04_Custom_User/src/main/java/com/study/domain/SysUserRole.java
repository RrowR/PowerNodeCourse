package com.study.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRole implements Serializable {
    private Integer userid;

    private Integer roleid;

    private static final long serialVersionUID = 1L;
}