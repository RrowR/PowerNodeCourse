package com.study;

import com.study.dao.GoodsDao;
import com.study.domain.Goods;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class EsstartApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private GoodsDao goodsDao;

    @Test
    void contextLoads() {
        System.out.println(elasticsearchRestTemplate);
    }

    @Test
    void testIndex() {
        // 得到索引信息
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(Goods.class);
        boolean b = indexOperations.create();
        System.out.println(b);
        // 创建mapping(字段映射)
        Document mapping = indexOperations.createMapping(Goods.class);
        boolean b1 = indexOperations.putMapping(mapping);
        System.out.println(b1);
    }

    @Test
    void testDocument(){
        ArrayList<Goods> goods = new ArrayList<>();
        for (int i = 1; i < 200; i++) {
            goods.add(new Goods(
                    i,
                    i % 2 == 0 ? "华为笔记本电脑" : "联想笔记本电脑",
                    i % 2 == 0 ? "轻薄本，颜值高，女生喜欢，办公很好" : "游戏本，高性能，高色域，价格优惠",
                    i % 2 == 0 ? 8999D + i : 4999D + i,
                    i % 2 == 0 ? "华为高端品牌" : "联想小新系列",
                    i % 2 == 0 ? 199L + i : 889L + i,
                    i % 2 == 0 ? Arrays.asList("上新", "延保", "双十一") : Arrays.asList("有赠品", "秒杀", "学生党"),
                    new Date()
            ));
        }
        // 使用继承了 ElasticsearchRepository 接口的接口方法，来对es进行数据的插入
        goodsDao.saveAll(goods);
    }

    @Test
    void testFindAllById(){
        Iterable<Goods> allById = goodsDao.findAllById(Arrays.asList(1, 2, 3));
        allById.forEach(goods -> {
            System.out.println(goods.getGoodsName());
        });
    }

    @Test
    void testFindById(){
        Goods goods = goodsDao.findById(1).get();
        System.out.println(goods.getGoodsName());
    }


    @Test
    void testUpdate(){
        Goods goods = goodsDao.findById(6).get();
        goods.setGoodsName("猫羽雫");
        // es没有修改，只能先查再修改
        Goods save = goodsDao.save(goods);
        System.out.println(save);
    }

    //  分词（精确匹配 模糊匹配 ）  组合条件  排序 分页  高亮   权重

    /*
        模糊匹配 match 会对查询的词进行分词
     */
    @Test
    void matchQuery(){
        // 构建一个条件构造器
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("goodsName","猫羽雫");
        // 构建一个条件组合器
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        // 填装查询条件
        nativeSearchQueryBuilder.withQuery(matchQuery);
        // 设置分页
        nativeSearchQueryBuilder.withPageable(PageRequest.of(0,2));
        // 根据指定字段进行降序排序
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("goodsPrice").order(SortOrder.DESC));
        // 执行查询结果
        SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), Goods.class);
        List<Goods> goods = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        System.out.println(goods);
    }

    /*
        term 精准匹配   只能全匹配keyword的类型属性
     */
    @Test
    void termQuery(){
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("id", "3");
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(termQueryBuilder)
                .build();
        SearchHits<Goods> search = elasticsearchRestTemplate.search(build, Goods.class);
        Goods goods = search.stream().iterator().next().getContent();
        System.out.println(goods);
    }

    /**
     * matchPhraseQuery 不会分词 词组查询 (根据词组精准匹配)
     * 查找全称  全称不会分词  可以用text修饰
     */
    @Test
    void matchPhraseQuery(){
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("goodsName", "猫羽雫");
        NativeSearchQuery query = new NativeSearchQueryBuilder().withQuery(matchPhraseQueryBuilder).build();
        SearchHits<Goods> goods = elasticsearchRestTemplate.search(query, Goods.class);
        List<Goods> list = goods.stream().map(SearchHit::getContent).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 组合查询
     * match + range
     */
    @Test
    void matchAndRangeQuery(){
        // 匹配名字
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("goodsName", "笔记本电脑");
        // 匹配价格范围
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("goodsPrice").from(5006D).to(9093D);
        // 组合条件查询BoolQueryBuilder
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery().must(matchQuery).must(rangeQueryBuilder);
        NativeSearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHits<Goods> goodsSearchHits = elasticsearchRestTemplate.search(query, Goods.class);
        List<Goods> goodsList = goodsSearchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        System.out.println(goodsList.size());
        System.out.println(goodsList);
    }

    /*
        高亮查询
     */
    @Test
    void heigtLightQuery(){
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("goodsName", "猫羽雫");
        // 设置高亮字段
        HighlightBuilder.Field field = new HighlightBuilder.Field("goodsName");
        field.preTags("<i style='color:red'>");
        field.postTags("<i/>");
        NativeSearchQuery query = new NativeSearchQueryBuilder().withQuery(matchQuery).withHighlightFields(field).build();
        SearchHits<Goods> goodsSearchHits = elasticsearchRestTemplate.search(query, Goods.class);
        goodsSearchHits.forEach(goodsSearchHit -> {
            // 查询出商品
            Goods goods = goodsSearchHit.getContent();
            // 查询出带高亮得商品
            String goodsName = goodsSearchHit.getHighlightField("goodsName").get(0);
            // 将商品名字替换成高亮的商品名字
            goods.setGoodsName(goodsName);
        });
        List<Goods> list = goodsSearchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        list.forEach(System.out::println);
    }



















}
