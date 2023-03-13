package com.example.casenhom3.service.order;

import com.example.casenhom3.model.Order;
import com.example.casenhom3.model.OrderDetail;
import com.example.casenhom3.service.IEcommerce;

import java.sql.Date;
import java.util.List;

public interface OrderService extends IEcommerce<Order>
{
    List<Order> findOrderByDate(Date start, Date end);

    OrderDetail getOrderDetailById(long orderId);


}
