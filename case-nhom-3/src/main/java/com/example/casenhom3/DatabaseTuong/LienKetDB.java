package com.example.casenhom3.DatabaseTuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LienKetDB {
        private static String jdbcURL = "jdbc:mysql://localhost:3306/test";
        private static String acc = "root";
        private static String pass = "tuong2001";
        private static String className = "com.mysql.cj.jdbc.Driver";


        public static Connection getConnection () {
            Connection connection = null;
            try {
                Class.forName(className);
                connection = DriverManager.getConnection(jdbcURL, acc, pass);
                System.out.println("connection successfully");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
