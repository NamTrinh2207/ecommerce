package com.example.casenhom3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?useUnicode=yes&characterEncoding=UTF-8";
    private static final String userDoan = "Nam";
    private static final String passDoan = "Anhnam220797anhnam";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, userDoan, passDoan);
            Class.forName(DRIVER);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}