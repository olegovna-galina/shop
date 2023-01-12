package com.solutions.shop.service;

import com.solutions.shop.dto.UserDto;
import com.solutions.shop.mapping.MappingUser;
import com.solutions.shop.model.User;

import com.solutions.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository iUserRepository;

    @Autowired
    private PasswordEncoder encoder;

    /**
     *
     * Registration (create new User)
     *
     * @param userDto UserDto
     * @return userDto UserDto
     */
    @Transactional
    public UserDto createUser(UserDto userDto) {
        if (userDto.getUserId() != null) {
            MappingUser mapping = new MappingUser();
            User user = mapping.mapToUser(userDto);
            String password = user.getPassword();
            String passwordHash = encoder.encode(password);
            user.setPassword(passwordHash);
            iUserRepository.save(user);
            return mapping.mapToUserDto(user);
        }
        return null;
    }

    /**
     *
     * find User with login (for admin)
     *
     * @param login UserDto login
     * @return userDto UserDto
     */
    @Transactional
    public UserDto findUser(String login) {
        List<User> users = iUserRepository.findByLogin(login); //should find only 1 user
        if (users.isEmpty()) {
            return null;
        } else {
            MappingUser mapping = new MappingUser();
            UserDto userDto = mapping.mapToUserDto(users.get(0));
            return userDto;
        }
    }
}
