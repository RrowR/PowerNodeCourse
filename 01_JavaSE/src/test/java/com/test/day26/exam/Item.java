package com.test.day26.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    private String question;
    private HashMap<String,String> hashMap;
    private String answer;
}
