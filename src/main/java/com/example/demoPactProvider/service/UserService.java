package com.example.demoPactProvider.service;

import com.example.demoPactProvider.model.User;

public class UserService {
    public User randomUser(String firstName){

        User user = new User();
        user.setAge(12);
        user.setFirstName(firstName);
        user.setLastName("Johnson");
        user.setPosition("Admin");
        user.setPostalCode("1111");
        return user;
    }
}
