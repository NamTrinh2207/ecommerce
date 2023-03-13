package com.example.casenhom3.model;

import java.sql.Date;

public abstract class Admin extends Person{
    public Admin() {
    }

    public Admin(long id, String code, String name, Date date, String address, String email, String phone) {
        super(id, code, name, date, address, email, phone);
    }
}
