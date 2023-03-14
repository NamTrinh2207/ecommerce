package com.example.casenhom3.controller.service;

import java.util.List;

public interface IEcommerce<T> {
    List<T> findAll();

    void save(T t);

    T findById(long id);

    void update(long id, T t);

    void delete(long id);
}
