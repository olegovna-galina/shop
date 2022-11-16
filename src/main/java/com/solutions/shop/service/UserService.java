package com.solutions.shop.service;

import com.solutions.shop.model.User;

import com.solutions.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* The service implements CRUD operations. */

@Service
public class UserService {

    @Autowired
    private UserRepository iUserRepository;

    public User createUser(User user){
        if (user.getUserId() != null){
            return iUserRepository.save(user);
        }
        return null;
    }
}
