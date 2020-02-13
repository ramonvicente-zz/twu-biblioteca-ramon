package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;
    private User loggedUser = null;

    public UserService(){
        userRepository = new UserRepository();
    }

    public void login(String libraryNumber, String password) {
        User user = new User(libraryNumber, password);
        loggedUser = userRepository.getUser(user);
    }

    public boolean isLogged(){
        if (loggedUser != null){
            return true;
        }
        return false;
    }
}
