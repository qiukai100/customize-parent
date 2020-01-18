package com.customize.service.core;

import java.util.List;

public interface BaseService<T, ID>  {

    T insertSelective(T t) throws Exception;

    T updateByPrimaryKeySelective(T t) throws Exception;

    int deleteByPrimaryKey(ID id) throws Exception;

    T selectByPrimaryKey(ID id) throws Exception;

    List<T> selectAll() throws Exception;
}
