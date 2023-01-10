package com.solutions.shop.mapping;

import com.solutions.shop.dto.UserDto;
import com.solutions.shop.model.User;

public class MappingUser {

    public UserDto mapToUserDto(User entity) {
        UserDto dto = new UserDto();
        dto.setUserId(entity.getUserId());
        dto.setLogin(entity.getLogin());
        return dto;
    }

    public User mapToUser(UserDto dto) {
        User entity = new User();
        entity.setUserId(dto.getUserId());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
