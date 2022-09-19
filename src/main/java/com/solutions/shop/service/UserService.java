package com.solutions.shop.service;

import com.solutions.shop.model.Users;

import com.solutions.shop.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* The service implements CRUD operations. */

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public Users createUser(Users user){
        if (user.getId() != null){
            return iUserRepository.save(user);
        }
        return null;
    }
}
