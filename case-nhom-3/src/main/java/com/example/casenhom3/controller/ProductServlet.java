package com.example.casenhom3.controller;

import com.example.casenhom3.model.Product;
import com.example.casenhom3.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    int id = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        if(product == null){
            response.sendRedirect("productServlet");
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            request.setAttribute("product", product);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/productServlet.create.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        request.setAttribute("", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                creteProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        double price = Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("img");
        String describe = request.getParameter("describe");
        Product product = this.productService.findById(id);
        if(product == null){
            response.sendRedirect("productServlet");
        }else {
            product.setCode();
        }
    }

    private void creteProduct(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        double price = Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("img");
        String describe = request.getParameter("img");
        Product product = new Product(id, code, price, img, describe);
        this.productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
