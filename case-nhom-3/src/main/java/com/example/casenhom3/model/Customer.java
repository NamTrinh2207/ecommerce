package com.example.casenhom3.model;

import java.sql.Date;

public class Customer {
    private Long id;
    private String customerCode;
    private String customerName;
    private Date customerDate;
    private String customerPlace;
    private String customerEmail;
    private String customerPhone;

    public Customer(Long id, String customerCode, String customerName, Date customerDate, String customerPlace, String customerEmail, String customerPhone) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerDate = customerDate;
        this.customerPlace = customerPlace;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public Customer(String customerCode, String customerName, Date customerDate, String customerPlace, String customerEmail, String customerPhone) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerDate = customerDate;
        this.customerPlace = customerPlace;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(Date customerDate) {
        this.customerDate = customerDate;
    }

    public String getCustomerPlace() {
        return customerPlace;
    }

    public void setCustomerPlace(String customerPlace) {
        this.customerPlace = customerPlace;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
