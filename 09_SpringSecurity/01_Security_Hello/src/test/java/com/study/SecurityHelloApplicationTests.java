package com.study;

import org.junit.jupiter..Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityHelloApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode1 = passwordEncoder.encode("123");
        System.out.println(encode1);
        String encode2 = passwordEncoder.encode("123");
        System.out.println(encode2);
        String encode3 = passwordEncoder.encode("123");
        System.out.println(encode3);


        // 查看密码是否匹配，这里不需要配置盐值
        System.out.println(passwordEncoder.matches("123", "$2a$10$ncR1XFq4fHQRA1ouy/sHBemLE887KuMIZzsxHLFO/iKcLMTyY.8vK"));
        System.out.println(passwordEncoder.matches("123", "$2a$10$1xQrsPGPQN35V92dTUefdua6LZs12sIIGwViDCIyTAsbuhvjpYv5i"));
        System.out.println(passwordEncoder.matches("123", "$2a$10$CLyKej7T2iHRC0yluDt6nO.M0XInIQqhecAKO7iZ7h5Dhj8Szom/2"));
    }

}
