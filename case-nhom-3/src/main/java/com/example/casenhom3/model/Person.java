package com.example.casenhom3.model;

import java.sql.Date;

public class Person {
    private long id;
    private String code;
    private String name;
    private Date date;
    private String address;
    private String email;
    private String phone;
    public Person()
    {

    }
    public Person(long id)
    {
        this.id = id;
    }

    public Person(long id, String code, String name, Date date, String address, String email, String phone) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.date = date;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
