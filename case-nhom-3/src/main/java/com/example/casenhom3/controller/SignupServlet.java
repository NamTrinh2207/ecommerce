package com.example.casenhom3.controller;

import com.example.casenhom3.service.DAO.CheckLogin;
import com.example.casenhom3.model.AcountSignUp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SingupServlet", value = "/SingupServlet")
public class SignupServlet extends HttpServlet {
    CheckLogin checkLogin=new CheckLogin();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        String confirm_password=request.getParameter("confirm_password");
        if (!password.equals(confirm_password)){
            response.sendRedirect("/login/signup.jsp");
        }else {
            AcountSignUp acountSignUp=checkLogin.acountSignUp(name,password);
            if (acountSignUp==null){
                HttpSession session= request.getSession();
//                session.setAttribute("name",name);
//                session.setAttribute("password",password);
                checkLogin.signUp(name,password);
                response.sendRedirect("/index.jsp");
            }else {
                response.sendRedirect("/login/signup.jsp");
            }
        }
    }
}