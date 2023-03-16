package com.example.casenhom3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?useUnicode=yes&characterEncoding=UTF-8";
    private static final String userNguyen = "root";
<<<<<<< HEAD
    private static final String passNguyen = "tuong2001";
=======
    private static final String passNguyen = "10061995";
>>>>>>> 237e8a5b50f56fa138b9e7b824e17a1def2a1fd4

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, userNguyen, passNguyen);
            System.out.println("connection successfully");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}