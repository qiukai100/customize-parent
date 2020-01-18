package com.customize.service.core;

import com.customize.mybatis.core.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    private final BaseMapper<T> mapper;

    @Autowired
    public BaseServiceImpl(BaseMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public T insertSelective(T t) throws Exception {
        mapper.insertSelective(t);
        return t;
    }

    @Override
    public T updateByPrimaryKeySelective(T t) throws Exception {
        mapper.updateByPrimaryKeySelective(t);
        return t;
    }

    @Override
    public int deleteByPrimaryKey(ID id) throws Exception {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(ID id) throws Exception {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() throws Exception {
        return mapper.selectAll();
    }
}
