package com.solutions.shop.service;

import com.solutions.shop.model.User;

import com.solutions.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* The service implements CRUD operations. */

@Service
public class UserService {

    @Autowired
    private UserRepository iUserRepository;

    @Autowired
    private PasswordEncoder encoder;

    /* Registration */
    public User createUser(User user){
        if (user.getUserId() != null){
            String password = user.getPassword();
            String passwordHash = encoder.encode(password);
            user.setPassword(passwordHash);
            return iUserRepository.save(user);
        }
        return null;
    }

    /* Log-In */
    public User findUser(String login, String password){
        List<User> users = iUserRepository.findByLogin(login); //should find only 1 user
        String passwordHash = users.get(0).getPassword();
        if (passwordHash == encoder.encode(password)){
            return users.get(0);
        }
        return null;
    }
}
