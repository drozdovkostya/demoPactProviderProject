package com.example.demoPactProvider.controller;

import com.example.demoPactProvider.model.User;
import com.example.demoPactProvider.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @GetMapping("findUser/{firstName}")
    public User findUserByName(@PathVariable String firstName){

        UserService userService = new UserService();
        return userService.randomUser(firstName);
    }


}
