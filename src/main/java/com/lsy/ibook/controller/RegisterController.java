package com.lsy.ibook.controller;

import com.lsy.ibook.bean.User;
import com.lsy.ibook.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterController {
    @Resource
    private UserService userService;

    @PostMapping("/user/{yhm}/{pwd}")
    public boolean register(@PathVariable String yhm,@PathVariable String pwd){
        // 如果用户名已被注册
        if(userService.selectByYhm(yhm)){
            return false;
        }
        // 用户名没被注册，则进行注册
        else{
            User user = new User();
            user.setYhm(yhm);
            user.setPwd(pwd);
            user.setYhsf("3"); // 新注册用，身份默认为 3 （普通用户）
            return userService.addUser(user);
        }
    }
}
