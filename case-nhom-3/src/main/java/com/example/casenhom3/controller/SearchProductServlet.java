package com.example.casenhom3.controller;

import com.example.casenhom3.model.Product;
import com.example.casenhom3.service.DAO.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchProductServlet", value = "/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch=request.getParameter("txt");
        ProductDAO productDAO=new ProductDAO();
        List<Product> list=productDAO.findByName(txtSearch);
        request.setAttribute("list",list);
        request.setAttribute("txtst",txtSearch);
        request.getRequestDispatcher("/listsearch.jsp").forward(request,response);
    }
}