package com.customize.redis.service.impl;

import com.customize.redis.cache.RedisTemplateCache;
import com.customize.redis.dto.KeyValueDto;
import com.customize.redis.service.RedisService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RedisServiceImpl<K, V> implements RedisService<K, V> {

    @Autowired
    public RedisServiceImpl(RedisTemplate<K, V> redisTemplate) {
        RedisTemplateCache.initCache(redisTemplate);
    }

    @Value("${spring.redis.database}")
    public void setRedisDB(int currentDB) {
        RedisTemplateCache.initCache(currentDB);
    }

    @Override
    public RedisTemplate changeDB(Integer dbNo) {
        if (dbNo == null) return RedisTemplateCache.getDefaultTemplate();
        RedisTemplate template = RedisTemplateCache.get(dbNo);
        if (template != null) return template;
        template = RedisTemplateCache.getDefaultTemplate();
        LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) template.getConnectionFactory();
        // assert: 参数为Boolean类型，为true时继续执行，否则抛出异常
        assert connectionFactory != null;
        connectionFactory.setDatabase(dbNo);
        template.setConnectionFactory(connectionFactory);
        connectionFactory.resetConnection();
        RedisTemplateCache.put(dbNo, template);
        return template;
    }

    @Override
    public Boolean hasKey(Integer dbNo, K key) {
        RedisTemplate redisTemplate = changeDB(dbNo);
        return redisTemplate.hasKey(key);
    }

    @Override
    public V get(Integer dbNo, K key) {
        RedisTemplate redisTemplate = changeDB(dbNo);
        if (key == null || !hasKey(dbNo, key)) {
            return null;
        }
        return (V) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(Integer dbNo, K key, V value) {
        RedisTemplate redisTemplate = changeDB(dbNo);
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(Integer dbNo, K key, V value, long offset) {
        RedisTemplate redisTemplate = changeDB(dbNo);
        redisTemplate.opsForValue().set(key, value, offset);
    }

    @Override
    public void remove(Integer dbNo, K key) {
        RedisTemplate redisTemplate = changeDB(dbNo);
        if (key != null && hasKey(dbNo, key)) {
            redisTemplate.delete(key);
        }
    }

    @Override
    public Set<K> selectAllKey(Integer dbNo, K pattern) {
        RedisTemplate redisTemplate = changeDB(dbNo);
        return redisTemplate.keys(pattern);
    }

    @Override
    public List<KeyValueDto> selectAll(Integer dbNo, K pattern) {
        Set<K> keys = selectAllKey(dbNo, pattern);
        List<KeyValueDto> list = Lists.newArrayList();
        if (keys != null && !keys.isEmpty())
            keys.forEach(key -> list.add(new KeyValueDto(key, get(dbNo, key))));
        return list;
    }
}
