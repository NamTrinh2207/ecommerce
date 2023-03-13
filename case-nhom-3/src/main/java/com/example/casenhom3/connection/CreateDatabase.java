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

    public Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER,PASSWORD);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            System.out.println("Connection Error");
        }

        return connection;
    }
}