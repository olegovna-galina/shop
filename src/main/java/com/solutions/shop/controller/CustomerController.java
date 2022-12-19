package com.solutions.shop.controller;

import com.solutions.shop.dto.CustomerDto;
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

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomerInfo(@RequestBody CustomerDto customer) {
        customerService.addInfoForUser(customer.getUserId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAddress());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
