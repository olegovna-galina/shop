package com.solutions.shop.controller;

import com.solutions.shop.dto.UserDto;
import com.solutions.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user/{login},{password}")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("user/{login},{password}")
    public ResponseEntity<UserDto> findUserByLogin(@PathVariable("login") String login,
                                                   @PathVariable("password") String password) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUser(login, password));
    }
}
