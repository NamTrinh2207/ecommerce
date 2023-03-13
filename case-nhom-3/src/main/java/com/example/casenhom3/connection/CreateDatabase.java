package com.example.casenhom3.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private  final String databaseName = "ecommerce";
    private  final String DRIVER = "com.mysql.jdbc.Driver";
    private  final String URL = "jdbc:mysql://localhost:3306/"+databaseName;
    private  final String USER = "Nam";
    private  final String PASSWORD = "Anhnam220797anhnam";

    public Connection getConnection() throws SQLException
    {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dang ket noi toi co so du lieu ...");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}