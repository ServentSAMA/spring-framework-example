package com.example.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void redisPubSubTest(){
        redisTemplate.convertAndSend("screen","张三:");
    }

}
