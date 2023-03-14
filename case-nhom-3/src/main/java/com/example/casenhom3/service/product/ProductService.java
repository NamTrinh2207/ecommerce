package com.example.casenhom3.service.product;

import com.example.casenhom3.DAO.ProductDAO;
import com.example.casenhom3.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    List<Product> products = new ArrayList<>();
    private ProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product findById(long id) {
        return productDAO.findById(id);
    }


    @Override
    public void update(long id, Product product) {
        productDAO.update(id, product);
    }

    @Override
    public void delete(long id) {
        productDAO.delete(id);
    }

    public List<Product> findByName(String name){
        return productDAO.findByName(name);
    }
}
