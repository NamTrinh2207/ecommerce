package com.example.casenhom3.model;

import java.sql.Date;

public class Employee {

    private Long id;
    private String employeeCode;
    private String employeeName;
    private Date employeeDate;
    private String employeePlace;
    private String employeeEmail;
    private String employeePhone;

    public Employee(Long id, String employeeCode, String employeeName, Date employeeDate, String employeePlace, String employeeEmail, String employeePhone) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeDate = employeeDate;
        this.employeePlace = employeePlace;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
    }

    public Employee(String employeeCode, String employeeName, Date employeeDate, String employeePlace, String employeeEmail, String employeePhone) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeDate = employeeDate;
        this.employeePlace = employeePlace;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(Date employeeDate) {
        this.employeeDate = employeeDate;
    }

    public String getEmployeePlace() {
        return employeePlace;
    }

    public void setEmployeePlace(String employeePlace) {
        this.employeePlace = employeePlace;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
}
