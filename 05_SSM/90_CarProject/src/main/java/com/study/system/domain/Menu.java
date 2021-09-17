package com.study.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer id;

    private Integer pid;

    private String title;

    private String href;

    private String target;

    private String icon;

    /**
    * 0不可用1可用
    */
    private Integer available;
}