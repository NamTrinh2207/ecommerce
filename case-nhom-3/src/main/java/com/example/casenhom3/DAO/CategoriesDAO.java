package com.example.casenhom3.DAO;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO {
    private final Connection connection = CreateDatabase.getConnection();
    private final String SELECT_ALL_CATEGORY = "select * from categories; ";
    private final String SELECT_CATEGORY_BY_ID = "select id,categoriesName from categories where id = ?; ";
    private final String INSERT_CATEGORY = "insert into categories(categoriesName) value(?);";
    private final String UPDATE_CATEGORY = "update categories set categoriesName = ? where id = ?;";
    private final String DELETE_CATEGORY = "delete from categories where id = ?;";


    public List<Categories> findAll() {
        List<Categories> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                categories.add(new Categories(resultSet.getLong(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Categories findById(Long id) {
        Categories categories = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories = new Categories(resultSet.getLong("id"),
                        resultSet.getString("categoriesName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void create(Categories category) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY)) {
            preparedStatement.setString(1, category.getCategoriesName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(long id, Categories categories) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY);
            statement.setString(1, categories.getCategoriesName());
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
