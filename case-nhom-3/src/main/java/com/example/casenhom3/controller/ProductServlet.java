package com.example.casenhom3.controller;

import com.example.casenhom3.model.Product;
import com.example.casenhom3.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    long id = 0;

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
                deleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "search" :

                break;
            default:
                listProduct(request, response);
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> products = this.productService.findByName(name);
        if (products == null) {
            response.sendRedirect("/productServlet");
            System.out.println("ko tim thay");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            request.setAttribute("product", products);
            dispatcher.forward(request, response);
            System.out.println("Tim thay");
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
                deleteProduct(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        request.setAttribute("product", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        if (product == null) {
            response.sendRedirect("productServlet");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            request.setAttribute("product", product);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        if (product == null) {
            response.sendRedirect("productServlet");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("delete.jsp");
            request.setAttribute("product", product);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/productServlet");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void creteProduct(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        double price = Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("img");
        String describe = request.getParameter("describe");
        String name = request.getParameter("name");
        Product product = new Product(id, code, name, price, img, describe);
        this.productService.save(product);
        id++;
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        double price = Double.parseDouble(request.getParameter("price"));
        String img = request.getParameter("img");
        String describe = request.getParameter("describe");
        String name = request.getParameter("name");
        Product product = this.productService.findById(id);
        if (product == null) {
            response.sendRedirect("productServlet");
        } else {
            product.setProductCode(code);
            product.setProductPrice(price);
            product.setProductImage(img);
            product.setProductDescribe(describe);
            product.setProductName(name);
            this.productService.update(id, product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
            request.setAttribute("product", product);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            try {
                dispatcher = request.getRequestDispatcher("productServlet");
                dispatcher.forward(request, response);
            } catch (IOException | ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.productService.delete(id);
            try {
                response.sendRedirect("productServlet");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
