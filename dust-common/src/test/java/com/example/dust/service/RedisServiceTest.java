package com.example.dust.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class RedisServiceTest {
    @Autowired
    private RedisService redisService;

    @Test
    void get() {
        String testKey = "TTT:KKK";
        String testValue = "value\0";

        redisService.set(testKey, testValue, 20);
        String getValue = redisService.get(testKey);
        log.info("get value:{} test value:{}", getValue, testValue);
        assertEquals(testValue, getValue);
    }
}