package com.example.casenhom3.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Check", value = "/check")
public class Check extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            if (session.getAttribute("account")==null){
                request.getRequestDispatcher("login/login.jsp").forward(request,response);
            }else {
                String action = request.getParameter("action");
                switch (action){
                    case "create":
                        request.getRequestDispatcher("")
                }
            }
    }
}
