package com.solutions.shop.service;

import com.solutions.shop.DAO.JpaCustomerDao;
import com.solutions.shop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomerService {
    private JpaCustomerDao jpaCustomerDao;

    public Optional<Customer> getCustomer(Integer id) {
        return jpaCustomerDao.get(id);
    }

    public List<Customer> getAllUsers() {
        return jpaCustomerDao.getAll();
    }

    public void updateUser(Customer customer) {
        jpaCustomerDao.update(customer);
    }

    public void saveUser(Customer customer) {
        jpaCustomerDao.save(customer);
    }

    public void deleteUser(Customer customer) {
        jpaCustomerDao.delete(customer);
    }
}
