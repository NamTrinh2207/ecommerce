package com.example.casenhom3.service.product;

import com.example.casenhom3.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }


    @Override
    public void update(long id, Product product) {
        products.set((int) id, product);
    }

    @Override
    public void delete(long id) {
        products.remove(id);
    }
}
