package com.study.dao;

import com.study.domain.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao extends ElasticsearchRepository<Goods,Integer> {
}
