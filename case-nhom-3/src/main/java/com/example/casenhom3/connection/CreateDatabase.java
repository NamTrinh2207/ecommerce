package com.example.casenhom3.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String databaseName = "ecommerce";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/"+databaseName;
    private static final String USER = "Nam";
    private static   final String PASSWORD = "Anhnam220797anhnam";

    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection =DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            System.out.println("Connection Error");
        }

        return connection;
    }
}