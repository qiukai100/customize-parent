package com.customize.redis.service;

import com.customize.redis.dto.KeyValueDto;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

public interface RedisService<K, V> {

    /**
     * 切换redis的数据库
     *
     * @param dbNo 数据库编号
     */
    RedisTemplate changeDB(Integer dbNo);

    /**
     * 根据KEY查找是否存在
     *
     * @param key 键
     * @return true 已存在
     */
    Boolean hasKey(Integer dbNo, K key);

    /**
     * 根据KEY查找VALUE
     *
     * @param key 键
     * @return 值
     */
    V get(Integer dbNo, K key);

    /**
     * 设置永久键值对
     *
     * @param key   键
     * @param value 值
     */
    void set(Integer dbNo, K key, V value);

    /**
     * 设置有效期键值对
     *
     * @param key    键
     * @param value  值
     * @param offset 失效时间 要大于0 如果time小于等于0 将设置无限期
     */
    void set(Integer dbNo, K key, V value, long offset);

    /**
     * 根据键删除值
     *
     * @param key 键
     */
    void remove(Integer dbNo, K key);

    /**
     * 获取所有key
     */
    Set<K> selectAllKey(Integer dbNo, K pattern);

    /**
     * 获取所有内容
     */
    List<KeyValueDto> selectAll(Integer dbNo, K pattern);

}
