package com.example.casenhom3.controller;

import com.example.casenhom3.service.DAO.AccountDao;
import com.example.casenhom3.model.AccountAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
AccountDao accountDao=new AccountDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        AccountAdmin accountAdmin1=accountDao.checkLogin(username,password);
        if (accountAdmin1==null){
            request.setAttribute("mess","Đăng Nhập Sai Xin Hãy Đăng Nhập Lại");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }else {
            response.sendRedirect("/employees?page=1");
        }
    }
}
