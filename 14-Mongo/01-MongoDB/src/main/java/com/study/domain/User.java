package com.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "user")
public class User {
    /**
     * 索引id
     *
     * @Id 标记为主键
     */
//    @Id
    @MongoId            // 里面包含了@Id
    private String id;

    /**
     * @Field 标记为MongoDB的属性字段，也可以不添加
     * @Indexed 给该字段新建索引，能提高查询速度
     */
    @Field(targetType = FieldType.STRING)
    @Indexed
    private String name;

    /**
     * 可以指定别名
     */
    @Field(value = "birth_day", targetType = FieldType.DATE_TIME)
    private Date birth;

    /**
     * 这里注意 类型需要指定泛型中的类型 不要使用FieldType.ARRAY
     */
    @Field(targetType = FieldType.STRING)
    private List<String> hobby;

    @Field(targetType = FieldType.STRING)
    private String address;

    @Field(targetType = FieldType.INT32)
    private Integer age;

    @Field(targetType = FieldType.BOOLEAN)
    private Boolean man;

    @Field(targetType = FieldType.DOUBLE)
    private Double price;

}
