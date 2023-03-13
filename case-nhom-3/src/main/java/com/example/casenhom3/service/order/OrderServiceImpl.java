package com.example.casenhom3.service.order;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.Customer;
import com.example.casenhom3.model.Employee;
import com.example.casenhom3.model.Order;
import com.example.casenhom3.model.Person;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService
{
    private Connection connection;

    public OrderServiceImpl()
    {
        connection = CreateDatabase.getConnection();
    }

    @Override
    public List<Order> findAll()
    {
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("select * from _order o");
                s.append(" ");
                s.append("join _customer c on o.customer_id = c.id");
                s.append(" ");
                s.append("and ");
                s.append("_employee e on o.employee_id = e.id");
                List<Order> orders = new ArrayList<>();
                PreparedStatement p = connection.prepareStatement(s.toString());
                ResultSet rs = p.executeQuery();
                while (rs.next())
                {
                    long order_id = rs.getLong("id");
                    Date orderDate = rs.getDate("orderDate");

                    int orderStatus = rs.getInt("status");

                    Long customer_id = rs.getLong("customer_id");
                    String customerCode = rs.getString("customerCode");
                    String customerName = rs.getString("customerName");
                    Date customerDate = rs.getDate("customerDate");
                    String customerPlace = rs.getString("customerPlace");
                    String customerEmail = rs.getString("customerEmail");
                    String customerPhone = rs.getString("customerPhone");
                    Long employee_id = rs.getLong("employee_id");
                    String employeeCode = rs.getString("employeeCode");
                    String employeeName = rs.getString("employeeName");
                    Date employeeDate = rs.getDate("employeeDate");
                    String employeePlace = rs.getString("employeePlace");
                    String employeeEmail = rs.getString("employeeEmail");
                    String employeePhone = rs.getString("employeePhone");
                    Customer customer = new Customer(customer_id, customerCode, customerName,customerDate,customerPlace, customerEmail, customerPhone);
                    Employee employee = new Employee(employee_id, employeeCode, employeeName,employeeDate, employeePlace, employeeEmail,employeePhone);
                    Order order = new Order(order_id, customer, employee,orderDate, orderStatus);
                    orders.add(order);
                }
            }
            catch (SQLException e)
            {
                System.out.println("Query Error");
            }

        }
        return null;
    }

    @Override
    public void save(Order order)
    {

    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Order order)
    {

    }

    @Override
    public void delete(int id)
    {

    }
}
