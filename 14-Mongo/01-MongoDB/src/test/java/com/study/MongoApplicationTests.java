package com.study;

import com.mongodb.client.MongoCollection;
import com.study.dao.UserDao;
import com.study.domain.User;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.*;

@SpringBootTest
class MongoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User user = new User("1", "nachaco", new Date(), Arrays.asList("play", "sleep"), "pixiv", 16, false, 999.11);
        User insert = mongoTemplate.insert(user);
        System.out.println(insert);
    }

    /*
        删除集合
     */
    @Test
    void testDeleteColletions(){
        mongoTemplate.dropCollection(User.class);
    }

    @Test
    void testCreateColletions(){
        MongoCollection<Document> collection = mongoTemplate.createCollection(User.class);
        System.out.println(collection);
    }

    @Test
    void testDocSave() throws InterruptedException {
        ArrayList<User> users = new ArrayList<>(200);
        for (int i = 0; i < 100; i++) {
            users.add(new User(
                    UUID.randomUUID().toString().substring(0, 15),
                    i % 2 == 0 ? "亚索" : "盖伦",
                    new Date(),
                    i % 2 == 0 ? Arrays.asList("吹风", "哈萨克") : Arrays.asList("大宝剑", "转转转"),
                    i % 2 == 0 ? "峡谷" : "德玛西亚",
                    20 + i,
                    i % 2 == 0,
                    (double) (6300 + i)
            ));
            // 让每个人的日期不同
            Thread.sleep(100);
        }
        userDao.saveAll(users);
        System.out.println("插入数据成功");
    }

    /*
        根据id来进行修改
        注意:这是一次不安全的修改，会让其他值为空
     */
    @Test
    void testUnSafeUpdate(){
        User user = new User();
        // mongodb里的id
        user.setId("086a97b5-bd26-4");
        user.setName("猫羽雫");
        User save = userDao.save(user);
        System.out.println(save);
    }

    /*
        安全的修改
     */
    @Test
    void testSafeUpdate(){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is("6c6576be-ebf6-4"));
        Update update = Update.update("name", "nachaco");
        mongoTemplate.updateFirst(query,update,User.class);
    }

    @Test
    void testDel(){
        userDao.deleteById("a183e66b-06f9-4");
    }

    // 条件查询
    @Test
    void testUserDaoFind(){
        // 根据id查询
        Optional<User> userDaoById = userDao.findById("086a97b5-bd26-4");
        System.out.println(userDaoById.get());
        // 查询所有
        List<User> users = userDao.findAll();
        System.out.println(users);
        // 根据条件查询
        User user = new User();
        user.setName("猫羽雫");
        Optional<User> userDaoOne = userDao.findOne(Example.of(user));
        System.out.println(userDaoOne);
    }

    /*
        多条件复杂查询
     */
    @Test
    void findByMultipleCriteria(){
        // 构造条件
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("亚索").and("age").lt(38));
        // 执行条件
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users);
    }

    /*
        分页查询
     */
    @Test
    void testQueryByPage(){
        Query query = new Query();
        query.addCriteria(Criteria.where("price").gte("6320"));
        query.with(PageRequest.of(0,20,        // 分页
                Sort.Direction.DESC         // 倒序
                ,"price")              // 排序字段
        );

        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users.size());
        System.out.println(users);
    }

    @Test
    void testQueryBySkipAndLimit(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC,"birth"));
        query.skip(3).limit(10);            // 跳过前3个，向后取10个
        List<User> users = mongoTemplate.find(query, User.class);
        users.forEach(System.out::println);
    }

    /*
        测试自定义接口的查询
     */
    @Test
    void testCustomInterfacesMethod(){
        User user = userDao.findAllById("086a97b5-bd26-4");
        System.out.println(user);
    }


}
