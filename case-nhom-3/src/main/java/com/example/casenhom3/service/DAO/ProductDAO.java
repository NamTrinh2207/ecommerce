package com.example.casenhom3.service.DAO;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.Product;
import com.example.casenhom3.service.IEcommerce;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IEcommerce<Product> {
    private final Connection connection = CreateDatabase.getConnection();
    private final String SELECT_ALL_PRODUCT = "select * from product; ";
    private final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?; ";
    private final String INSERT_PRODUCT = "insert into product(code, name, price, img, describee) value(?,?,?,?,?);";
    private final String UPDATE_PRODUCT = "update product set code=?, name=?, price=?,img=?,describee=? where id = ?;";
    private final String DELETE_PRODUCT = "delete from product where id = ?;";
    private final String FIND_BY_NAME = "select id,productCode,productName,productPrice,productImage,productDescribe from product where productName " +
            "like concat('%' , ? , '%') ;";

    private final String FIND_PRODUCT_HAVE_MAX_PRICE = "select * from product where price >= all(select max(price) from product);";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCT);
            while (resultSet.next()) {
                products.add(new Product(resultSet.getLong("id"),
                        resultSet.getString("productCode"),
                        resultSet.getString("productName"),
                        resultSet.getDouble("productPrice"),
                        resultSet.getString("productImage"),
                        resultSet.getString("productDescribe")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void save(Product product) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT);) {
            statement.setString(1, product.getProductCode());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getProductPrice());
            statement.setString(4, product.getProductImage());
            statement.setString(5, product.getProductDescribe());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(long id, Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setDouble(3, product.getProductPrice());
            preparedStatement.setString(4, product.getProductImage());
            preparedStatement.setString(5, product.getProductDescribe());
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(long id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product(resultSet.getLong("id"),
                        resultSet.getString("productCode"),
                        resultSet.getString("productName"),
                        resultSet.getDouble("productPrice"),
                        resultSet.getString("productImage"),
                        resultSet.getString("productDescribe"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public List<Product> findByName(String name) {
        List<Product> product = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product.add(new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("productCode"),
                        resultSet.getString("productName"),
                        resultSet.getDouble("productPrice"),
                        resultSet.getString("productImage"),
                        resultSet.getString("productDescribe")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;

    }


    public List<Product> findPriceMax() {
        List<Product> products = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_PRODUCT_HAVE_MAX_PRICE);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String img = resultSet.getString("img");
                String des = resultSet.getString(6);
               Product product = new Product(id, code, name, price, img, des);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

}