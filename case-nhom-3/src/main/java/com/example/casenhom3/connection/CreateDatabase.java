package com.example.casenhom3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String userDoan = "root";
    private static final String passWordDoan = "10061995";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?useUnicode=yes&characterEncoding=UTF-8";
    private static final String USER = "Nam";
    private static final String PASSWORD = "Anhnam220797anhnam";

    private static String jdbcURLTuong = "jdbc:mysql://localhost:3306/test";
    private static String accTuong = "root";
    private static String passTuong = "tuong2001";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connection successfully");
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, userDoan, passWordDoan);
            System.out.println("connection successfully");
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(jdbcURLTuong, accTuong, passTuong);
            System.out.println("connection successfully");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}