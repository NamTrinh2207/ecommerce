package com.example.casenhom3.service.customer;

import com.example.casenhom3.service.DAO.CustomerDAO;
import com.example.casenhom3.model.Customer;

import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public Customer findById(long id) {
        return customerDAO.findbyId(id);
    }

    @Override
    public void update(long id, Customer customer) {
        customerDAO.updateCustomer(id, customer);
    }

    @Override
    public void delete(long id) {
        customerDAO.deleteCustomer((int) id);
    }

    public List<Customer> findByPhone(String phone) {
        return this.customerDAO.findCustomerByPhone(phone);
    }

    public List<Customer> sorfByName(){
        return this.customerDAO.sortByName();
    }
}
