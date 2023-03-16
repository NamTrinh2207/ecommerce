package com.example.casenhom3.service.category;

import com.example.casenhom3.service.DAO.CategoriesDAO;
import com.example.casenhom3.model.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory {
    List<Categories> categories = new ArrayList<>();
    CategoriesDAO categoriesDAO = new CategoriesDAO();

    @Override
    public List<Categories> findAll() {
        return categoriesDAO.findAll();
    }

    @Override
    public void save(Categories category) {
        categoriesDAO.create(category);
    }



    @Override
    public Categories findById(long id) {
        return categoriesDAO.findById(id);
    }

    @Override
    public void update(long id, Categories category) {
        categoriesDAO.update(id, category);
    }
    @Override
    public void delete(long id) {
        categoriesDAO.delete(id);
    }
}
