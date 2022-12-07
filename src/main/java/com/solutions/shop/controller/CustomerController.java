package com.solutions.shop.controller;

import com.solutions.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomerInfo(@RequestBody Integer userId,
                                                @RequestBody String firstName,
                                                @RequestBody String lastName,
                                                @RequestBody String address) {
        customerService.addInfoForUser(userId, firstName, lastName, address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
