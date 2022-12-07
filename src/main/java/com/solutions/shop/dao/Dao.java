package com.solutions.shop.dao;

import java.util.Optional;
import java.util.List;

public interface Dao<T> {
    Optional<T> get(Integer id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
