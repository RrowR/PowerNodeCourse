package com.study.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    /*
        根据第三组json数据格式可知，这个类似一个链表，每一个对象的数组里又包含了自己，故我们这样设计对象
     */
    private Integer id;
    private Integer pid;
    private String title;
    private String href;
    private String target;
    private String icon;
    private List<Node> child = new ArrayList<>();
}
