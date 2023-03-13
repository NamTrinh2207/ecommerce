package com.example.casenhom3.service.category;

import com.example.casenhom3.model.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory {
    List<Categories> categories = new ArrayList<>();

    @Override
    public List<Categories> findAll() {
        return categories;
    }

    @Override
    public void save(Categories category) {
        categories.add(category);
    }

    @Override
    public Categories findById(long id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                return categories.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(long id, Categories category)
    {
    }

    @Override
    public void delete(long id) {
        categories.remove(id);
    }
}
