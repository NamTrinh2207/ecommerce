package com.example.casenhom3.model;

import java.sql.Date;

public class Employee extends Person{
    public Employee() {
    }

    public Employee(Long id, String code, String name, Date date, String address, String email, String phone) {
        super(id, code, name, date, address, email, phone);
    }
}
