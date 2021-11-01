package com.study.service.impl;

import com.study.domain.Goods;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.study.service.GoodsService;
import com.study.utils.DbUtils;
import com.study.utils.InvertedIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private JiebaSegmenter jiebaSegmenter;

    @Override
    public void saveGoods(Goods goods) {
        // 存储数据到数据库
        Integer id = DbUtils.add(goods);
        // 对每条数据的name进行分词
        List<String> keyWords = fenci(goods.getName());
        // 存储这条数据的id和这条数据name的分词
        saveToIndex(id, keyWords);
    }

    private void saveToIndex(Integer id, List<String> keyWords) {
        // 获取一个String为key set为value的map集合，用来填装所有分词对应的Set<Id>
        HashMap<String, Set<Integer>> map = InvertedIndex.index;
        keyWords.forEach(keyword -> {
            Set<Integer> oldIds = map.get(keyword);
            // 如果这个分词对应的Set<Id>集合不存在
            if (CollectionUtils.isEmpty(oldIds)) {
                // 则新建一个Id的set集合 并添加进去
                HashSet<Integer> newIds = new HashSet<>();
                newIds.add(id);
                // 再将每个分词对应的Set<Id>放到map中
                map.put(keyword, newIds);
            } else {
                // 如果对应 分词 的set<Id>集合已经存在，则直接添加对应的id到Set<Id>集合中去即可
                oldIds.add(id);
            }
        });

    }

    private List<String> fenci(String name) {
        List<SegToken> process = jiebaSegmenter.process(name, JiebaSegmenter.SegMode.INDEX);
        List<String> collect = process.stream().map(w -> w.word).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Goods> findGoodByKeyWords(String keyword) {
        // 先根据名称进行分词
        List<String> keywords = fenci(keyword);
        // 去出所有分词对应的Set<Id>
        HashMap<String, Set<Integer>> index = InvertedIndex.index;
        // 创建一个总的id集合
        HashSet<Integer> allIds = new HashSet<>();
        keywords.forEach(word -> {
            Set<Integer> ids = index.get(word);
            // 如果当前分词对应的Set<Id>有值
            if (!CollectionUtils.isEmpty(ids)) {
                // 将查询出来的set<Id>的值添加到allIds里去(也是一个set集合)
                allIds.addAll(ids);
            }
        });
        // 根据allIds里拥有的id来进行查询所有的货物
        List<Goods> goodsByIds = DbUtils.findGoodsByIds(allIds);
        return goodsByIds;
    }
}
