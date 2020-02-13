package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    UserService userService;

    @Before
    public void setUp(){
        userService = new UserService();
    }

    @Test
    public void shouldExecuteLogin(){
        String libraryNumber = "123-4567";
        String password = "1234567";
        userService.login(libraryNumber, password);
        Assert.assertTrue(userService.isLogged());
    }
}
