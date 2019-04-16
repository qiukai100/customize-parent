package com.customize.service.core;

import com.customize.jpa.core.BaseJpaServiceImpl;
import com.customize.jpa.core.BaseRepository;
import com.customize.redis.server.RedisServer;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T, ID> extends BaseJpaServiceImpl<T, ID> implements BaseService<T, ID> {

    public BaseServiceImpl(BaseRepository<T, ID> repository) {
        super(repository);
    }

    @Autowired
    private RedisServer redisServer;
}
