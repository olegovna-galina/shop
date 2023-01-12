package com.solutions.shop.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    private Integer userId;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
