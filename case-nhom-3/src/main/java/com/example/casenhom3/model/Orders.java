package com.example.casenhom3.model;

import java.sql.Date;

public class Orders {
    private long id;
    private Customer customer_id;
    private Employee employee_id;
    private Date orderDate;
    private int status;

    public Orders() {
    }

    public Orders(long id, Customer customer_id, Employee employee_id, Date orderDate, int status) {
        this.id = id;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.orderDate = orderDate;
        this.status = status;
    }
    public Orders(long id, Customer customer_id, Employee employee_id, Date orderDate)
    {
        this.id = id;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.orderDate = orderDate;
        this.status = 2;
    }
    public Orders(Customer customer_id)
    {
        this.customer_id = customer_id;
    }

    public Orders(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}