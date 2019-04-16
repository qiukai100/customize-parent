package com.customize.web.core;

import com.customize.redis.server.RedisServer;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

    @Autowired
    private RedisServer redisServer;

}
