package com.example.casenhom3.service.order;

import com.example.casenhom3.connection.CreateDatabase;
import com.example.casenhom3.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService
{
    private Connection connection;


    public OrderServiceImpl()
    {

    }

    // 39.Hiển thị báo cáo bán hàng theo ngày
    private List<Order> orderListResult(ResultSet rs) throws SQLException
    {
        List<Order> orderList = new ArrayList<>();
        while (rs.next())
        {
            long order_id = rs.getLong("id");
            Date orderDate = rs.getDate("orderDate");
            int orderStatus = rs.getInt("status");
            Long customer_id = rs.getLong("customer_id");
            Long employee_id = rs.getLong("employee_id");
            Customer customer = new Customer(customer_id);
            Employee employee = new Employee(employee_id);
            Order order = new Order(order_id, customer, employee,orderDate, orderStatus);
            orderList.add(order);
        }
        return orderList;
    }


    // 70. Hiển thị danh sách đơn hàng
    @Override
    public List<Order> findAll()
    {
        connection = CreateDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("select * from orders");
                PreparedStatement p = connection.prepareStatement(s.toString());
                ResultSet rs = p.executeQuery();
                return orderListResult(rs);
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
    //71.Xem chi tiết đơn hàng theo orderId
    @Override
    public OrderDetail getOrderDetailById(long orderId)
    {
        connection = CreateDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("select * from orderdetail");
                s.append(" ");
                s.append("join product on orderdetail.product_id = product.id where orderdetail.order_id = ?");
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
    // 72,78  Tìm kiếm đơn hàng theo khoảng thời gian
    @Override
    public List<Order> findOrderByDate(Date start, Date end)
    {
        connection = CreateDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                String sql = "select * from orders where orderDate between ? and ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setDate(1, start);
                p.setDate(2, end);
                ResultSet rs = p.executeQuery();
                return orderListResult(rs);

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
    public Order findById(long orderId)
    {
        connection = CreateDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("select * from orders, customer, employee ");
                s.append(" ");
                s.append("where customer.id = orders.customer_id and employee.id = orders.employee_id and orders.id = ?");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setLong(1, orderId);
                ResultSet rs = p.executeQuery();
                if (rs.next())
                {
                    long customer_id = rs.getLong("customer_id");
                    long employee_id = rs.getLong("employee_id");
                    Date orderDate = rs.getDate("orderDate");
                    int status = rs.getInt("status");
                    Customer customer= new Customer(customer_id);
                    Employee employee = new Employee(employee_id);
                    Order order = new Order(orderId,customer, employee,orderDate,status);
                    return order;
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

    // 74 Hiển thị tổng tiền đơn hàng
    @Override
    public double allOrderSum()
    {
        connection = CreateDatabase.getConnection();
        double sum = 0;
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("select sum(orderdetail.amount) as amountSum from orderdetail, orders  ");
                s.append(" ");
                s.append("where orders.id = orderdetail.order_id and orders.status = 1");
                PreparedStatement p = connection.prepareStatement(s.toString());
                ResultSet rs = p.executeQuery();
                if (rs.next())
                {
                    sum = rs.getDouble("amountSum");
                }
            }
            catch (SQLException e)
            {
                System.out.println("Query Error ");
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
        return sum;
    }

    // 75. Hiển thị tổng tiền khách hàng đã đặt hàng
    @Override
    public List<OrderDetail> amountSumOfCustomer()
    {
        connection = CreateDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                List<OrderDetail> orderDetails = new ArrayList<>();
                StringBuilder s = new StringBuilder();
                s.append("select customer.id, code, name, date,address,email, phone, sum(orderdetail.amount) as amountSum");
                s.append(" ");
                s.append("from orderdetail , orders , customer ");
                s.append(" ");
                s.append("where orderdetail.order_id = orders.id and customer.id = orders.customer_id and orders.status = 1");
                s.append(" ");
                s.append("group by customer.id, code, name, date,address,email, phone");
                PreparedStatement p = connection.prepareStatement(s.toString());
                ResultSet rs = p.executeQuery();
                while (rs.next())
                {
                    long customerId = rs.getLong("id");
                    String customerCode = rs.getString("code");
                    String customerName = rs.getString("name");
                    Date customerDate = rs.getDate("date");
                    String customerPlace = rs.getString("address");
                    String customerEmail = rs.getString("email");
                    String customerPhone = rs.getString("phone");
                    double sumAmount = rs.getDouble("amountSum");

                    Customer customer = new Customer(customerId,customerCode,customerName,customerDate, customerPlace, customerEmail, customerPhone);
                    Order order = new Order(customer);
                    OrderDetail orderDetail = new OrderDetail(order, sumAmount);
                    orderDetails.add(orderDetail);
                }
                return orderDetails;
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
    // Tạo hóa đơn
    @Override
    public void save(Order order)
    {
        connection = CreateDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                s.append("insert into orders(customer_id,employee_id,orderDate,status) values(?,?,?,?)");
                PreparedStatement p = connection.prepareStatement(s.toString());
                p.setLong(1, order.getCustomer_id().getId());
                p.setLong(2,order.getEmployee_id().getId());
                p.setDate(3, order.getOrderDate());
                p.setInt(4, order.getStatus());
                p.executeUpdate();

                s = new StringBuilder();
                s.append("insert into orderdetail(order_id,product_id,quantity,amount) values(?,?,?,?)");
                p = connection.prepareStatement(s.toString());
                p.setLong(1, order.getId());
            }
            catch (SQLException e)
            {
                System.out.println("Connection Error");
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
    }


    // 76+77 Cập nhật + Hủy đơn hàng(hóa đơn)
    @Override
    public void orderUpdate(long customerId, long orderId, int status)
    {
        connection = CreateDatabase.getConnection();
        if (connection != null)
        {
            try
            {
                StringBuilder s = new StringBuilder();
                if (status == 0 || status == 1 || status == 2)
                {
                    if (status == 0)
                    {
                        s.append("Delete from orders , orderdetail  ");
                        s.append(" ");
                        s.append("where orders.id = orderdetail.order_id and orders.id = ? and orders.customer_id = ? and orders.status = ? and orders.status = 0");
                        PreparedStatement p = connection.prepareStatement(s.toString());
                        p.setLong(1,orderId);
                        p.setLong(2, customerId);
                        p.setInt(3, status);
                        p.executeUpdate();
                    }
                    else
                    {
                        s = new StringBuilder();
                        s.append("update orders set status = ?");
                        s.append(" ");
                        s.append("where id = ? and customer_id = ? ");
                        PreparedStatement p = connection.prepareStatement(s.toString());
                        p.setInt(1, status);
                        p.setLong(2, orderId);
                        p.setLong(3,customerId);
                        p.executeUpdate();
                    }
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
    }

    @Override
    public void update(long id, Order order)
    {

    }
    @Override
    public void delete(long id)
    {

    }

}
