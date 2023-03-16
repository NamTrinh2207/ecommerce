package com.example.casenhom3.service.admin;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.Admin;
import com.example.casenhom3.model.Customer;
import com.example.casenhom3.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {
    private static final String sql = "select * from admin where user = ? and password = ?";
    private static final String SELECT_ACCOUNT_EMPLOYEE = "select code, name, date, address, email, phone from employee where email = ? and code = ?";
    private static final String SELECT_ACCOUNT_CUSTOMER = "select code, name, date, address, email, phone from customer where email = ? and code = ?";
    Connection connection = CreateDatabase.getConnection();

    public Admin checkLoginAdmin(String user, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Admin(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getInt(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Employee checkLoginEmployee(String email, String code) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_EMPLOYEE);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Customer checkLoginCustomer(String email, String code) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_CUSTOMER);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}