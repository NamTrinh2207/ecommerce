package com.example.casenhom3.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String Doan="root";
    private static final String jdbcURLdoan = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String PassWord="10061995";
    private static final String databaseName = "ecommerce";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/"+databaseName;
    private static final String USER = "Nam";
    private static final String PASSWORD = "Anhnam220797anhnam";
    private static String jdbcURL = "jdbc:mysql://localhost:3306/test";
    private static String acc = "root";
    private static String pass = "tuong2001";
    private static String className ="com.mysql.cj.jdbc.Driver" ;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURLdoan, Doan, PassWord);
            System.out.println("connection successfully");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

}