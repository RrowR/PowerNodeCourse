package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        Integer count = jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
        System.out.println(count);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap("select * from user where id = 1");
        System.out.println(stringObjectMap);
        List<Map<String, Object>> mao = jdbcTemplate.queryForList("select * from user where name like ?", "%猫%");
        System.out.println(mao);
    }

}
