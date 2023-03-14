package com.example.casenhom3.controller;

import com.example.casenhom3.service.order.OrderService;
import com.example.casenhom3.service.order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/orders")
public class OrderServlet extends HttpServlet
{
    private OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action == null)
        {
            action = "";
        }
        else if (action.equals("edit"))
        {

        }
        else
        {
            req.setAttribute("orders", orderService.findAll());
            req.getRequestDispatcher("/order/orderList.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");
        if (action == null)
        {
            action = "";
        }
        switch (action)
        {
            case "search":
        }
    }
}
