package com.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum QueueEnums {

    RENT_HOUSE_QUEUE("rent.house.queue"),
    RENT_HOUSE_EX("rent.house.ex"),
    RENT_HOUSE_KEY("rent.house.key");

    private String queueName;

}
