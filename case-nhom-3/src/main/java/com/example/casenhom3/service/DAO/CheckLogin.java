package com.example.casenhom3.service.DAO;

import com.example.casenhom3.model.AcountSignUp;
import com.example.casenhom3.connection.CreateDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLogin {
    private static final String SAVE_ACCOUNT="insert into  logincustomer(user, password) values (?,?);";
    private static final String checkLOg="select * from logincustomer where user = ? and password = ?;";
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    public AcountSignUp acountSignUp(String name ,String password) {
        {
            try {
                connection = CreateDatabase.getConnection();
                preparedStatement = connection.prepareStatement(checkLOg);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2,password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    return new AcountSignUp(resultSet.getString(1),resultSet.getString(2));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }return null;
    }
    public void signUp(String name,String password){
        connection=CreateDatabase.getConnection();
        try {
            preparedStatement=connection.prepareStatement(SAVE_ACCOUNT);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}