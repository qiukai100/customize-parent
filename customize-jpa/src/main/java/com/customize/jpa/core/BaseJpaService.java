package com.customize.jpa.core;

import java.util.List;

public interface BaseJpaService<T, ID> {
    T findById(ID id);

    List<T> selectAll();

    T save(T t);

    void deleteById(ID id);
}
