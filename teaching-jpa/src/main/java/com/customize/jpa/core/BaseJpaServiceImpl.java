package com.customize.jpa.core;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseJpaServiceImpl<T, ID extends Serializable> implements BaseJpaService<T, ID> {

    private BaseRepository<T, ID> repository;

    public BaseJpaServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T findById(ID id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> selectAll() {
        return repository.findAll();
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public void deleteById(ID id) {
        repository.delete(id);
    }
}
