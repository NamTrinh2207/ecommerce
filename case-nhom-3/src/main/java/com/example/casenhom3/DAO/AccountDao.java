package com.example.casenhom3.DAO;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.AccountAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    private static final String Login = "select *from login where user=?and password=?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public AccountAdmin checkLogin(String name, String password) {
        try {
            connection = CreateDatabase.getConnection();
            preparedStatement = connection.prepareStatement(Login);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                AccountAdmin admin = new AccountAdmin(resultSet.getString(1), resultSet.getString(2));
                return admin;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
