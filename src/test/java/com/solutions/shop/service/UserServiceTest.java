package com.solutions.shop.service;

import com.solutions.shop.model.User;
import com.solutions.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(UserService.class)
public class UserServiceTest {
    @MockBean
    UserRepository userRepositoryMock;

    @Autowired
    private UserService userService;

    @Test
    public void createUser_success() throws Exception {
        User record = new User();
        record.setUserId(1);
        record.setLogin("TestLogin");
        record.setPassword("TestPassword");

        Mockito.when(userRepositoryMock.save(record)).thenReturn(record);

        User user2 = userService.createUser(record);

        var result = user2.getLogin();
        assertEquals(record.getLogin(), result);
    }
}
