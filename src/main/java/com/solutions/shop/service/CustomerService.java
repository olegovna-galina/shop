package com.solutions.shop.service;

import com.solutions.shop.dao.JpaCustomerDao;
import com.solutions.shop.dto.ResultDTO;
import com.solutions.shop.model.Customer;
import com.solutions.shop.model.User;
import com.solutions.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private JpaCustomerDao jpaCustomerDao;

    @Autowired
    private UserRepository iUserRepository;

    /**
     *
     * Add Information to the personal account.
     *
     * @param userId User ID
     * @param firstName Customer first name
     * @param lastName Customer last name
     * @param address Customer address
     * @return response ResultDTO
     */
    @Transactional
    public ResultDTO addInfoForUser(Integer userId, String firstName, String lastName, String address) {
        User user = iUserRepository.getReferenceById(userId);
        Integer customerId = user.getUserId();
        Customer customer = new Customer(customerId, user, firstName, lastName, address);
        jpaCustomerDao.save(customer);
        return new ResultDTO("Information saved successfully!");
    }
}
