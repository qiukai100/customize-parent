package com.customize.redis.service.impl;

import com.customize.redis.config.RedisConfig;
import com.customize.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    private static int currentDB = RedisConfig.getRedisDB();
    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public RedisServiceImpl(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void changeDB(int dbNo) {
        if (dbNo == currentDB) return;
        LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
        // assert: 参数为Boolean类型，为true时继续执行，否则抛出异常
        assert connectionFactory != null;
        connectionFactory.setDatabase(dbNo);
        redisTemplate.setConnectionFactory(connectionFactory);
        connectionFactory.resetConnection();
        currentDB = dbNo;
    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Object get(String key) {
        if (key == null || !hasKey(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long offset) {
        redisTemplate.opsForValue().set(key, value, offset);
    }

    @Override
    public void remove(String key) {
        if (key != null && hasKey(key)) {
            redisTemplate.delete(key);
        }
    }
}
