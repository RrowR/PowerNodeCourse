package com.study.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;

    private String name;

    private String address;

    private Date birth;

    private Integer flag;
}