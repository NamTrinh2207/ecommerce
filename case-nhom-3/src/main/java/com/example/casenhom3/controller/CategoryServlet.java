package com.example.casenhom3.controller;

import com.example.casenhom3.model.Categories;
import com.example.casenhom3.service.category.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
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
                viewCategory(request, response);
                break;
            default:
                listCategory(request, response);
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
                createCategory(request, response);
                break;
            case "edit":
                editCategory(request, response);
                break;
            case "delete":
                delteteCategory(request, response);
                break;

            default:
                listCategory(request, response);
        }
    }

    private void viewCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Categories categories = this.categoryService.findById(id);
        RequestDispatcher dispatcher;
        if (categories == null) {
            dispatcher = request.getRequestDispatcher("CategoryServlet");
        } else {
            request.setAttribute("category", categories);
            dispatcher = request.getRequestDispatcher("view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) {
        List<Categories> categories = categoryService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
        request.setAttribute("category", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Categories categories = this.categoryService.findById(id);
        if (categories == null) {
            response.sendRedirect("CategoryServlet");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
            request.setAttribute("category", categories);
            dispatcher.forward(request, response);
        }
    }

    private void delteteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Categories categories = this.categoryService.findById(id);
        RequestDispatcher dispatcher;
        if (categories == null) {
            dispatcher = request.getRequestDispatcher("/CategoryServlet");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.categoryService.delete(id);
            response.sendRedirect("CategoryServlet");
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Categories categories = this.categoryService.findById(id);
        if (categories == null) {
            response.sendRedirect("CategoryServlet");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            request.setAttribute("category", categories);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String categoryName = request.getParameter("name");
        Categories categories = this.categoryService.findById(id);
        if (categories == null) {
            response.sendRedirect("CategoryServlet");
            System.out.println("BUGGG");
        } else {
            System.out.println("NO BUGGGG");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            categories.setCategoriesName(categoryName);
            this.categoryService.update(id, categories);
            request.setAttribute("category", categories);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) {
        String categoryName = request.getParameter("name");
        Categories categories = new Categories(id, categoryName);
        this.categoryService.save(categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
