package com.example.casenhom3.controller;

import com.example.casenhom3.model.Customer;
import com.example.casenhom3.service.customer.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();
    private long id = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreate(request, response);
                break;
            case "edit":
                formEdit(request, response);
                break;
            case "delete":
                formDelete(request, response);
                break;
            default:
                listCustomer(request, response);

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
                    createCustomer(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                findCustomerByPhone(request, response);
                break;
            case "sorf" :
                sorfByName(request, response);
                break;
            default:
                listCustomer(request, response);

        }
    }

    private void sorfByName(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.sorfByName();
        request.setAttribute("customer", customers);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("order.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Customer> customers = this.customerService.findAll();
            request.setAttribute("customer", customers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/CustomerServlet");
        } else {
            dispatcher = request.getRequestDispatcher("edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void formDelete(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/CustomerServlet");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String date1 = request.getParameter("date");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Date date = new java.sql.Date(format.parse(date1).getTime());
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Customer customer = new Customer(id, code, name, date, address, email, phone);
        this.customerService.save(customer);
        id++;
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date dateConvert;
        try {
            dateConvert = new Date(format.parse(date).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/CustomerServlet");
        } else {
            customer.setCode(code);
            customer.setName(name);
            customer.setDate(dateConvert);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setPhone(phone);
            this.customerService.update(id, customer);
            dispatcher = request.getRequestDispatcher("edit.jsp");
            request.setAttribute("customer", customer);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("/CustomerServlet");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.customerService.delete(id);
            response.sendRedirect("/CustomerServlet");
        }
    }

    private void findCustomerByPhone(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone");
        List<Customer> customers = this.customerService.findByPhone(phone);
        RequestDispatcher dispatcher;
        if (customers == null) {
            dispatcher = request.getRequestDispatcher("order.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("order.jsp");
            request.setAttribute("customer", customers);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
