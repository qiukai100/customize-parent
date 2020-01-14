package com.customize.redis.service;

public interface RedisService {

    /**
     * 切换redis的数据库
     *
     * @param dbNo 数据库编号
     */
    void changeDB(int dbNo);

    /**
     * 根据KEY查找是否存在
     *
     * @param key 键
     * @return true 已存在
     */
    Boolean hasKey(String key);

    /**
     * 根据KEY查找VALUE
     *
     * @param key 键
     * @return 值
     */
    Object get(String key);

    /**
     * 设置永久键值对
     *
     * @param key   键
     * @param value 值
     */
    void set(String key, Object value);

    /**
     * 设置有效期键值对
     *
     * @param key    键
     * @param value  值
     * @param offset 失效时间 要大于0 如果time小于等于0 将设置无限期
     */
    void set(String key, Object value, long offset);

    /**
     * 根据键删除值
     *
     * @param key 键
     */
    void remove(String key);
}
