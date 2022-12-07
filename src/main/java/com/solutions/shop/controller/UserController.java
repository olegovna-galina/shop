package com.solutions.shop.controller;

import com.solutions.shop.model.User;
import com.solutions.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Optional;

/* Logic of processing client requests. */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "user/{login},{password}")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "user/{login},{password}")
    public ResponseEntity<User> findUserByLogin(@PathVariable("login") String login,
                                             @PathVariable("password") String password){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUser(login, password));
    }
}
