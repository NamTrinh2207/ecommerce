package com.example.casenhom3.service;

import java.util.List;

public interface IEcommerce<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    void update(int id, T t);

    void delete(int id);
}
