package com.example.casenhom3.controller;

import com.example.casenhom3.model.Order;
import com.example.casenhom3.model.OrderDetail;
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
            case "detail":
                 long orderId = Long.parseLong(req.getParameter("orderId"));
                 OrderDetail orderDetail = orderService.getOrderDetailById(orderId);
                 req.setAttribute("orderDetail", orderDetail);
                 req.getRequestDispatcher("/order/orderDetail.jsp").forward(req,resp);
                 break;
            case "moneyTotal":
                req.setAttribute("customerOrders", orderService.amountSumOfCustomer());
                req.getRequestDispatcher("/order/customerOrderSum.jsp").forward(req,resp);
                break;
            case "statusUpdate":
                orderUpdateByStatus(req, resp);
                break;
            default:
                req.setAttribute("orderSum",orderService.allOrderSum());
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

            if (!startDate.equals("") && !endDate.equals(""))
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date start = new Date(dateFormat.parse(startDate).getTime());
                Date end = new Date(dateFormat.parse(endDate).getTime());
                List<Order> orderList = orderService.findOrderByDate(start, end);
                if (orderList == null)
                {
                    orderList = new ArrayList<>();
                }
                request.setAttribute("orders", orderList);
            }
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
    public void orderUpdateByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         long customerId = Long.parseLong(request.getParameter("customerId"));
         long orderId =  Long.parseLong(request.getParameter("orderId"));
         int status = Integer.parseInt(request.getParameter("status"));
         orderService.orderUpdate(customerId,orderId, status);
         response.sendRedirect("/orders");
    }
}
