package com.example.casenhom3.service.employee;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.Employee;
import com.example.casenhom3.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService, SearchAndListByPage<Employee> {
    private final Connection connection = CreateDatabase.getConnection();
    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (code,name,date,address, email, phone) VALUES (?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where id =?";
    private static final String SELECT_ALL_EMPLOYEES = "select * from employee";
    private static final String DELETE_EMPLOYEE = "delete from employee where id = ?;";
    private static final String UPDATE_EMPLOYEE = "update employee set code = ?,name = ?,date = ?,address = ?, email = ?, phone = ? where id = ?;";
    private final String SEARCH_BY_NAME = "select id,code,name,date,address,email,phone from ecommerce.employee where name " +
            "like concat('%' , ? , '%') ;";

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
                System.out.println("Query error");
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getCode());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDate(3, employee.getDate());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getPhone());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Query error");
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
                System.out.println("Query error");
            }
        }
        return null;
    }

    @Override
    public void update(long id, Employee employee) throws SQLException {
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);
                statement.setString(1, employee.getCode());
                statement.setString(2, employee.getName());
                statement.setDate(3, employee.getDate());
                statement.setString(4, employee.getAddress());
                statement.setString(5, employee.getEmail());
                statement.setString(6, employee.getPhone());
                statement.setLong(7, id);
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Query error");
            }
        }
    }

    @Override
    public void delete(long id) {
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Query error");
            }
        }
    }

    @Override
    public List<Employee> getListByPage(List<Employee> list, int start, int end) {
        List<Employee> employees = new ArrayList<>();
        for (int i = start; i < end; i++) {
            employees.add(list.get(i));
        }
        return employees;
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SEARCH_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String code = resultSet.getString("code");
                Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                Employee employee = new Employee(id, code, name, date, address, email, phone);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

}
