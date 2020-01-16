package com.customize.redis.cache;

import com.google.common.collect.Maps;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public class RedisTemplateCache {

    private static Integer defaultDBNo;

    private static RedisTemplate defaultTemplate;

    private static boolean initFlag = false;

    private static final Object initLock = new Object();

    private static Map<Integer, RedisTemplate<?, ?>> cacheMap = Maps.newConcurrentMap();

    private static void init() {
        synchronized (initLock) {
            if (initFlag || defaultDBNo == null || defaultTemplate == null) return;
            clear();
            put(defaultDBNo, defaultTemplate);
            initFlag = true;
        }
    }

    public static void initCache(Integer dbNo) {
        if (initFlag) return;
        defaultDBNo = dbNo;
        init();
    }

    public static void initCache(RedisTemplate template) {
        if (initFlag) return;
        defaultTemplate = template;
        init();
    }

    public static RedisTemplate put(Integer dbNo, RedisTemplate<?, ?> template) {
        if (containsKey(dbNo))
            return get(dbNo);
        return cacheMap.put(dbNo, template);
    }

    public static RedisTemplate get(Integer dbNo) {
        if (containsKey(dbNo))
            return cacheMap.get(dbNo);
        return null;
    }

    public static RedisTemplate remove(Integer dbNo) {
        if (!containsKey(dbNo))
            return null;
        return cacheMap.remove(dbNo);
    }

    public static boolean containsKey(Integer dbNo) {
        return cacheMap.containsKey(dbNo);
    }

    public static void clear() {
        cacheMap.clear();
    }

    public static Integer getDefaultDBNo() {
        return defaultDBNo;
    }

    public static RedisTemplate getDefaultTemplate() {
        return defaultTemplate;
    }
}
