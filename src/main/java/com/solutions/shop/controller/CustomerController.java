package com.solutions.shop.controller;

import com.solutions.shop.dto.CustomerDto;
import com.solutions.shop.dto.ResultDTO;
import com.solutions.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<String> createCustomerInfo(@RequestBody @Valid CustomerDto customer) {
        ResultDTO resultDTO = customerService.addInfoForUser(customer.getUserId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAddress());
        return new ResponseEntity<String>(resultDTO.getResponse(), HttpStatus.CREATED);
    }
}
