package com.example.casenhom3.service.employee;

import java.util.List;

public interface SearchAndListByPage<T> {
    List<T> getListByPage(List<T> list, int start, int end);

    List<T> searchByName(String name);
}