package com.customize.jpa.core;

import java.util.List;
import java.util.Optional;

public class BaseJpaServiceImpl<T, ID> implements BaseJpaService<T, ID> {

    private BaseRepository<T, ID> repository;

    public BaseJpaServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T findById(ID id) {
        Optional<T> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : null;
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
        repository.deleteById(id);
    }
}
