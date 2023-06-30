package com.example.data;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void redisPubSubTest(){
        redisTemplate.convertAndSend("screen","张三:");
    }

    @Test
    public void addValueOperations(){
        redisTemplate.opsForValue().set("key","value");
        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent("key", "value");
        if (ifAbsent){
            log.info("键已存在");
        }
        // 在值后面添加要添加的值 添加后值为：valuevalueAppend
        redisTemplate.opsForValue().append("key", "valueAppend");

    }

}
