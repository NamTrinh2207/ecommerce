package com.example.casenhom3.controller;

import com.example.casenhom3.model.Product;
import com.example.casenhom3.service.DAO.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServletInformation", value = "/ProductServletInformation")
public class ProductServletInformation extends HttpServlet {
    ProductDAO productDAO=new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long  pid= Long.valueOf(request.getParameter("pid"));
        Product product=productDAO.findById(pid);
        request.setAttribute("detailpd",product);
        request.getRequestDispatcher("Details.jsp").forward(request,response);

    }
}