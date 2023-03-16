package com.example.casenhom3.controller;

import com.example.casenhom3.model.Order;
import com.example.casenhom3.service.order.OrderService;
import com.example.casenhom3.service.order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
        switch (action)
        {
            case "edit":
                break;
            default:
                req.setAttribute("orders", orderService.findAll());
                req.getRequestDispatcher("/order/orderList.jsp").forward(req,resp);
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
            case "searchByDate":
                searchOrderByDate(req, resp);
                break;

        }
    }

    public void searchOrderByDate(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date start = new Date(dateFormat.parse(startDate).getTime());
            Date end = new Date(dateFormat.parse(endDate).getTime());
            List<Order> orderList = orderService.findOrderByDate(start, end);
            if (orderList == null)
            {
                orderList = new ArrayList<>();
            }
            request.setAttribute("orders", orderList);
            request.getRequestDispatcher("/order/orderList.jsp").forward(request,response);
        }
        catch (ParseException e) {
            System.out.println("Date Format Error !");
        }
        catch (ServletException | IOException e)
        {
            System.out.println("IO Exception");
        }
    }
    public void searchOrderById(HttpServletRequest request, HttpServletResponse response)
    {

    }
}
