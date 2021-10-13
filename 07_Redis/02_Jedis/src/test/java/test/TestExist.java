package test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class TestExist {
    @Test
    void TestKeyExist(){
        Jedis jedis = new Jedis("192.168.72.128", 6380);
        jedis.auth("123456");
        Boolean exists = jedis.exists("first:name");
        System.out.println(exists);
        jedis.close();
    }
}
