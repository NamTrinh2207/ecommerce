package com.example.casenhom3.controller.service.order;

import com.example.casenhom3.model.Order;
import com.example.casenhom3.model.OrderDetail;
import com.example.casenhom3.controller.service.IEcommerce;

import java.sql.Date;
import java.util.List;

public interface OrderService extends IEcommerce<Order>
{

    List<Order> findOrderByDate(Date start, Date end);

    OrderDetail getOrderDetailById(long orderId);

    List<OrderDetail> amountSumOfCustomer();

    int orderCancelByCustomer(long customerId, int status);

    double allOrderSum();

    int orderUpdate(long orderId, int status);





}
