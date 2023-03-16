package com.example.casenhom3.model;

public class Admin extends User{
    public Admin() {
    }

    public Admin(String username, String password) {
        super(username, password, 1);
    }
}
