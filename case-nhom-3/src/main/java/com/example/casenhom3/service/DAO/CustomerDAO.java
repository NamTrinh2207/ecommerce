package com.example.casenhom3.service.DAO;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private final Connection connection = CreateDatabase.getConnection();
    private final String SELECT_ALL_CUSTOMERS = "select * from customer;";
    private final String SELECT_CUSTOMERS_BY_ID = "select code,name,date,address,email,phone from customer where id =?;";
    private final String INSERT_CUSTOMERS = "insert into customer(code,name,date,address,email,phone) value(?,?,?,?,?,?);";
    private final String UPDATE_CUSTOMER = "update customer set   where id=?;";
    private final String DELETE_CUSTOMER = "delete from customer where id =?;";

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMERS);
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getLong("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getDate("date"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public void addCustomer(Customer customer) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMERS)) {
            statement.setString(1, customer.getCode());
            statement.setString(2, customer.getName());
            statement.setDate(3, customer.getDate());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findbyId(long id) {
        Customer customer = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMERS_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(resultSet.getLong("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getDate("date"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
