package com.example.casenhom3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?useUnicode=yes&characterEncoding=UTF-8";
    private static final String userDoan = "root";
    private static final String passDoan = "10061995";
    private static final String user_nam = "Nam";
    private static final String pass_nam = "Anhnam220797anhnam";
    private static final String userTuong = "root";
    private static final String passTuong = "tuong2001";
    private static final String userNguyen = "root";
    private static final String passNguyen = "Nguyen251096*";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, userDoan, passDoan);
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, user_nam, pass_nam);
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, userTuong, passTuong);
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, userNguyen, passNguyen);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}