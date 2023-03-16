package com.example.casenhom3.controller;

import com.example.casenhom3.model.Admin;
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
<<<<<<< HEAD
        request.getRequestDispatcher("login/login.jsp").forward(request, response);
=======
doPost(request, response);
>>>>>>> doan
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin1 = admin.checkLogin(username, password);
        HttpSession session = request.getSession();
        if (admin1 == null) {
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu !");
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
        } else {
            session.setAttribute("account", admin1);
            if (admin1.getRole() == 1) {
                request.getRequestDispatcher("/employees?page=1").forward(request, response);
            } else if (admin1.getRole() == 2) {
                request.getRequestDispatcher("/CustomerServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

=======
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        AccountAdmin accountAdmin1=accountDao.checkLogin(username,password);
        if (accountAdmin1==null){
            request.setAttribute("mess","Đăng Nhập Sai Xin Hãy Đăng Nhập Lại");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }else {
            response.sendRedirect("/employees?page=1");
>>>>>>> doan
        }
    }
}
