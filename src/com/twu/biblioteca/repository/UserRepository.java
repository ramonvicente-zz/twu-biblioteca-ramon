package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private List<User> users;

    public UserRepository(){
        users = Arrays.asList(
                new User("123-4567", "1234567"),
                new User("543-1234", "5431234"));
    }

    public User getUser(User user) {
        return users.stream().filter(userFound -> userFound.getLibraryNumber().equals(user.getLibraryNumber())
                && userFound.getPassword().equals(user.getPassword())).findFirst().orElse(null);
    }
}
