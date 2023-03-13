package model;

import java.sql.Date;

public class Order {

    private Long id;
    private Customer customer;
    private Employee employee;
    private Date orderDate;
    private int status;

    public Order(Long id, Customer customer, Employee employee, Date orderDate, int status) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Order(Customer customer, Employee employee, Date orderDate, int status) {
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
