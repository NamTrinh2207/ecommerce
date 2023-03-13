package com.example.casenhom3.service;

import java.util.List;

public interface IEcommerce<T> {
    List<T> findAll();

    void save(T t);

    T findById(long id);

<<<<<<< HEAD
    void update(int id, T product);

=======
    void update(long id, T t);
>>>>>>> d4f8b10d1264e811f3284f64fd3e595d9a767cac

    void delete(long id);
}
