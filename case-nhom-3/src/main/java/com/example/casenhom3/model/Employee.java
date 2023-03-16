package com.example.casenhom3.model;

import java.sql.Date;

public class Employee extends Person {
    private String image;

    public Employee(String image) {
        this.image = image;
    }

    public Employee(long id) {
        super(id);
    }

    public Employee(long id, String code, String name, Date date, String address, String email, String phone, String image) {
        super(id, code, name, date, address, email, phone);
        this.image = image;
    }

    public Employee(String code, String name, Date date, String address, String email, String phone, String image) {
        super(code, name, date, address, email, phone);
        this.image = image;
    }

    public Employee(String code, String name, Date date, String address, String email, String phone) {
        super(code, name, date, address, email, phone);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}