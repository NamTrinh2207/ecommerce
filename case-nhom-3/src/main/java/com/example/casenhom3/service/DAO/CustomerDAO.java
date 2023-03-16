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
    private final String UPDATE_CUSTOMER = "update customer set code=?,name=?,date=?,address=?,email=?,phone=?  where id=?;";
    private final String DELETE_CUSTOMER = "delete from customer where id =?;";
    private final String FIND_CUSTOMER_BY_PHONE = "select id,code,name,date,address,email from customer where phone=?;";

    private final String SORT_CUSTOMER_BY_NAME = "select * from customer order by name";

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMERS);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Customer customer = new Customer(id, code, name, date, address, email, phone);
                customers.add(customer);
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

    public void updateCustomer(long id, Customer customer) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER)) {
            statement.setString(1, customer.getCode());
            statement.setString(2, customer.getName());
            statement.setDate(3, customer.getDate());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPhone());
            statement.setLong(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomer(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findById(long id) {
        Customer customer = null;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERS_BY_ID);
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String code = resultSet.getNString("code");
                    String name = resultSet.getString("name");
                    Date date = resultSet.getDate("date");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    customer = new Customer(id, code, name, date, address, email, phone);
                }
                return customer;
            } catch (SQLException e) {
                System.out.println("Query error");
            }
        }
        return null;
    }

    public List<Customer> findCustomerByPhone(String phone) {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_CUSTOMER_BY_PHONE)) {
            statement.setString(1, phone);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("date");
                String address = resultSet.getString("date");
                String email = resultSet.getString("email");
                Customer customer = new Customer(id, code, name, date, address, email, phone);
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public List<Customer> sortByName() {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SORT_CUSTOMER_BY_NAME)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Customer customer = new Customer(id, code, name, date, address, email, phone);
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}









