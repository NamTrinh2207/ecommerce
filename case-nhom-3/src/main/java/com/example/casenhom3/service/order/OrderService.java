package com.example.casenhom3.service.order;

import com.example.casenhom3.model.Orders;
import com.example.casenhom3.model.OrderDetail;
import com.example.casenhom3.service.IEcommerce;

import java.sql.Date;
import java.util.List;

public interface OrderService extends IEcommerce<Orders>
{

    List<Orders> findOrderByDate(Date start, Date end);

    OrderDetail getOrderDetailById(long orderId);

    List<OrderDetail> amountSumOfCustomer();

    double allOrderSum();

    void orderUpdate(long customerId, long orderId, int status);

}