package com.customize.manage.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    /*@Resource
    private BaseMapper<T, ID> mapper;

    @Override
    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int deleteByPrimaryKey(ID id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Page<T> queryPage(T t, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(
                () -> mapper.selectAll()
        );
    }*/
}
