package com.customize.jpa.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

}
