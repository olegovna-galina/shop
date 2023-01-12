package com.solutions.shop.controller;

import com.solutions.shop.dto.ProductDto;
import com.solutions.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("product")
    public ResponseEntity<?> create(@RequestBody @Valid ProductDto product) {
        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
