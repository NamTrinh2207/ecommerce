package com.example.casenhom3.controller;

import com.example.casenhom3.model.Employee;
import com.example.casenhom3.service.IEcommerce;
import com.example.casenhom3.service.employee.EmployeeService;
import com.example.casenhom3.service.employee.ListByPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    IEcommerce<Employee> iEcommerce;
    ListByPage<Employee> list;

    @Override
    public void init() throws ServletException {
        iEcommerce = new EmployeeService();
        list = new EmployeeService();
    }

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
                deleteEmployee(request, response);
                break;
            case "view":
                view(request, response);
                break;
            default:
                listEmployee(request, response);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Employee> employees1 = iEcommerce.findAll();
            int page, numberPage = 8;
            int size = employees1.size();
            int num = (size % numberPage == 0 ? (size / numberPage) : ((size / numberPage)) + 1);
            String xPage = request.getParameter("page");
            if (xPage == null) {
                page = 1;
            } else {
                page = Integer.parseInt(xPage);
            }
            int start, end;
            start = (page - 1) * numberPage;
            end = Math.min(page * numberPage, size);
            List<Employee> employees = list.getListByPage(employees1, start, end);
            request.setAttribute("employees", employees);
            request.setAttribute("page", page);
            request.setAttribute("num", num);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = iEcommerce.findById(id);
            request.setAttribute("employee", employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/views.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = iEcommerce.findById(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/update.jsp");
            request.setAttribute("employee", employee);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
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
                try {
                    createEmployee(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    editEmployee(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                listEmployee(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            iEcommerce.delete(id);
            List<Employee> employees = iEcommerce.findAll();
            request.setAttribute("employees", employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String startDateStr = request.getParameter("date");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.sql.Date date = new java.sql.Date(sdf.parse(startDateStr).getTime());
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Employee employee = new Employee(id, code, name, date, address, email, phone);
            iEcommerce.update(id, employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/update.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        try {
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String startDateStr = request.getParameter("date");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.sql.Date date = new java.sql.Date(sdf.parse(startDateStr).getTime());
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Employee employee = new Employee(code, name, date, address, email, phone);
            iEcommerce.save(employee);
            request.getRequestDispatcher("employee/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
