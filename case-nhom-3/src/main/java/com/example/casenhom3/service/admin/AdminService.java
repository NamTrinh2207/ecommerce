package com.example.casenhom3.service.admin;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {
    private static final String sql = "select * from admin where user = ? and password = ?";
    Connection connection = null;

    public User checkLogin(String user, String password) {
        try {
            connection = CreateDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getInt(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
