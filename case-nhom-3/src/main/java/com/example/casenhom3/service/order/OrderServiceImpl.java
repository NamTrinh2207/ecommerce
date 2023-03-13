package com.example.casenhom3.service.order;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.*;
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

                    // get customer infomation
                    Long customer_id = rs.getLong("customer_id");
                    String customerCode = rs.getString("customerCode");
                    String customerName = rs.getString("customerName");
                    Date customerDate = rs.getDate("customerDate");
                    String customerPlace = rs.getString("customerPlace");
                    String customerEmail = rs.getString("customerEmail");
                    String customerPhone = rs.getString("customerPhone");

                    // get employee infomation
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
            finally
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Close Error");
                }

            }

        }
        return null;
    }

    @Override
    public void save(Order order)
    {

    }

    @Override
    public Order findById(long id)
    {
        return null;
    }

    @Override
    public void update(long id, Order order)
    {

    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public List<Order> findOrderByDate(Date start, Date end)
    {
        if (connection != null)
        {
            try
            {
                String sql = "select * from _order where orderDate between ? and ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setDate(1, start);
                p.setDate(2, end);
                ResultSet rs = p.executeQuery();
                List<Order> orderSearchByDate = new ArrayList<>();
                while (rs.next())
                {
                        long order_id = rs.getLong("id");
                        Date orderDate = rs.getDate("orderDate");
                        int orderStatus = rs.getInt("status");

                        // get customer infomation
                        Long customer_id = rs.getLong("customer_id");
                        String customerCode = rs.getString("customerCode");
                        String customerName = rs.getString("customerName");
                        Date customerDate = rs.getDate("customerDate");
                        String customerPlace = rs.getString("customerPlace");
                        String customerEmail = rs.getString("customerEmail");
                        String customerPhone = rs.getString("customerPhone");

                        // get employee infomation
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
                        orderSearchByDate.add(order);
                }
            }
            catch (SQLException e)
            {
                System.out.println("Query Error");
            }
            finally
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Close Error");
                }

            }
        }
        return null;
    }

    @Override
    public OrderDetail getOrderDetailById(long orderId)
    {
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("select * from _orderdetail o");
                s.append(" ");
                s.append("join product p on o.product_id = p.id where order_id = ?");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setLong(1, orderId);
                ResultSet rs = p.executeQuery();
                if (rs.next())
                {
                    long id = rs.getLong("id");
                    long product_id = rs.getLong("product_id");
                    String productCode = rs.getString("productCode");
                    String productName = rs.getString("productName");
                    double productPrice = rs.getDouble("productPrice");
                    String productImage = rs.getString("productImage");
                    String productDescribe = rs.getString("productDescribe");
                    int quantity = rs.getInt("quantity");
                    double amount = rs.getDouble("amount");
                    Order order = new Order(rs.getLong("order_id"));
                    Product product = new Product(product_id,productCode, productName, productPrice, productImage,productDescribe);
                    OrderDetail orderDetail = new OrderDetail(id, order, product,quantity, amount);
                    return orderDetail;
                }
            }
            catch (SQLException e)
            {
                System.out.println("Query Error");
            }
            finally
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Close Error");
                }
            }
        }

        return null;
    }
}
