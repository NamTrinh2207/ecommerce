package com.example.casenhom3.service;

import java.sql.SQLException;
import java.util.List;

public interface IEcommerce<T> {
    List<T> findAll();

    void save(T t);

    T findById(long id);

    void update(long id, T t) throws SQLException;

    void delete(long id);

}
