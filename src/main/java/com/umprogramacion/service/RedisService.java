package com.umprogramacion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private static final Logger log = LoggerFactory.getLogger(RedisService.class);

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveDeviceList(String deviceListJson) {
        redisTemplate.opsForValue().set("deviceList", deviceListJson);
    }

    public String getDeviceList() {
        return (String) redisTemplate.opsForValue().get("deviceList");
    }
}
