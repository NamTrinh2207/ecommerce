package com.example.casenhom3.service.employee;

import java.util.List;

public interface ListByPage<T> {
    List<T> getListByPage(List<T> list, int start, int end);
}
