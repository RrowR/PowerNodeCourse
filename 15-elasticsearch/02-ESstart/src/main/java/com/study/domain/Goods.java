package com.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
 * @Document是ES提供的注解 indexName:索引名称
 * createIndex：启动时是否创建
 * shards：分片个数
 * replicas：副本个数
 * refreshInterval：数据导入到索引里面，最多几秒搜索到
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "goods_index", createIndex = true, shards = 3, replicas = 1, refreshInterval = "1s")
public class Goods {
    /*
        ID不能进行分词
     */
    @Id
    @Field(name = "id", type = FieldType.Keyword)
    private Integer id;
    /*
     * searchAnalyzer 搜索这个属性的时候按照什么规则来分词
     * analyzer 导入分词
     */
    @Field(name = "goodsName", type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String GoodsName;
    @Field(name = "goodsDesc", type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String goodsDesc;
    @Field(name = "goodsPrice", type = FieldType.Double)
    private Double goodsPrice;
    @Field(name = "brand", type = FieldType.Text)
    private String brand;
    @Field(name = "stock", type = FieldType.Long)
    private Long stock;
    @Field(name = "tag", type = FieldType.Text)
    private List<String> tag;
    private Date createTime;
}
