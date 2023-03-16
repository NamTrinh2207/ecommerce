package com.example.casenhom3.model;

import java.sql.Date;

public class Employee extends User {
    private long id;
    private String code;
    private String name;
    private Date date;
    private String address;
    private String email;
    private String phone;
    private String image;

    public Employee(String code, String name, Date date, String address, String email, String phone, String image) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public Employee(long id, String code, String name, Date date, String address, String email, String phone, String image) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public Employee(String username, String password, String code, String name, Date date, String address, String email, String phone, String image) {
        super(username, password, 2);
        this.code = code;
        this.name = name;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
