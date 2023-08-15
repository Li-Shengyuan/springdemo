package com.lsy.ibook.controller;

import com.lsy.ibook.bean.User;
import com.lsy.ibook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController{
    @Autowired
    private UserService userService;

    @GetMapping("/user/one")
    public User login(User user) {
        return userService.selectUser(user);
    }
}
