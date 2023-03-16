package com.example.casenhom3.controller;

import com.example.casenhom3.model.Categories;
import com.example.casenhom3.model.Product;
import com.example.casenhom3.service.DAO.ProductDAO;
import com.example.casenhom3.service.category.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePageServlet", value = "/HomePageServlet")
public class HomePageServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    ProductDAO productDAO=new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> categories = categoryService.findAll();
        List<Product> products=productDAO.findAll();
        try {
            request.setAttribute("category", categories);
            request.setAttribute("product", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }




}
