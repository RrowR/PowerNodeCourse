package com.study.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private BigDecimal score;
}
