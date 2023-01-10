package com.solutions.shop.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerDto {

    private Integer userId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String address;
}
