package com.example.casenhom3.controller;

import com.example.casenhom3.model.Admin;
import com.example.casenhom3.model.Customer;
import com.example.casenhom3.model.Employee;
import com.example.casenhom3.service.admin.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    AdminService admin = new AdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin1 = admin.checkLoginAdmin(username, password);
        Employee employee = admin.checkLoginEmployee(username, password);
        Customer customer = admin.checkLoginCustomer(username, password);
        if (admin1 == null && employee == null && customer == null) {
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu !");
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }
        if (admin1 != null) {
            response.sendRedirect("/employees?page=1");
        }
        else if (employee != null) {
            response.sendRedirect("/CustomerServlet");
        }else if (customer != null){
            response.sendRedirect("/HomePageServlet");
        }
    }
}
