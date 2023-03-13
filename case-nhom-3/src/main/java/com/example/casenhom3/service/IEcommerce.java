package com.example.casenhom3.service;

import java.util.List;

public interface IEcommerce<T> {
    List<T> findAll();

    void save(T product);

    T findById(long id);

    void update(long id, T product);

    void delete(long id);
}
