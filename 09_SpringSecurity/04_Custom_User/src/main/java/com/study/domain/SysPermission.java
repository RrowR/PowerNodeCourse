package com.study.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission implements Serializable {
    private Integer id;

    private Integer perid;

    private String pername;

    private String percode;

    private static final long serialVersionUID = 1L;
}