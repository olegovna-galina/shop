package com.solutions.shop.service;

import com.solutions.shop.dao.JpaCustomerDao;
import com.solutions.shop.dto.ResultDTO;
import com.solutions.shop.model.Customer;
import com.solutions.shop.model.User;
import com.solutions.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CustomerService {
    @Autowired
    private JpaCustomerDao jpaCustomerDao;

    @Autowired
    private UserRepository iUserRepository;
    /*
        public Optional<Customer> getCustomer(Integer id) {
            return jpaCustomerDao.get(id);
        }

        public List<Customer> getAllUsers() {
            return jpaCustomerDao.getAll();
        }

        public void updateUser(Customer customer) {
            jpaCustomerDao.update(customer);
        }

        public void deleteUser(Customer customer) {
            jpaCustomerDao.delete(customer);
        }
    */

    /* Add Information to the personal account. */
    @Transactional
    public ResultDTO addInfoForUser(Integer userId, String firstName, String lastName, String address){
        User user = iUserRepository.getReferenceById(userId);
        Integer customerId = user.getUserId();
        Customer customer = new Customer(customerId, user, firstName, lastName, address);
        jpaCustomerDao.save(customer);
        return new ResultDTO("Information saved successfully!");
    }
}
