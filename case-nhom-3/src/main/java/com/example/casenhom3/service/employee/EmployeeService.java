package com.example.casenhom3.service.employee;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    CreateDatabase createDatabase = new CreateDatabase();
    private final Connection connection; = createDatabase.getConnection();
    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (code,name,date,address, email, phone) VALUES (?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where id =?";
    private static final String SELECT_ALL_EMPLOYEES = "select * from employee";
    private static final String DELETE_EMPLOYEE = "delete from employee where id = ?;";
    private static final String UPDATE_EMPLOYEE = "update employee set code = ?,name = ?,date = ?,address = ?, email = ?, phone = ? where id = ?;";

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String code = resultSet.getNString("code");
                    String name = resultSet.getString("name");
                    Date date = resultSet.getDate("date");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    employees.add(new Employee(id, code, name, date, address, email, phone));
                }
                return employees;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getCode());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDate(3, employee.getDate());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(long id) {
        Employee employee = null;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String code = resultSet.getNString("code");
                    String name = resultSet.getString("name");
                    Date date = resultSet.getDate("date");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    employee = new Employee(id, code, name, date, address, email, phone);
                }
                return employee;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void update(long id, Employee employee) {
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);
                statement.setString(1, employee.getCode());
                statement.setString(2, employee.getName());
                statement.setDate(3, employee.getDate());
                statement.setString(4, employee.getAddress());
                statement.setString(5, employee.getEmail());
                statement.setString(6, employee.getPhone());
                statement.setLong(7, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(long id) {
        if (connection != null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
