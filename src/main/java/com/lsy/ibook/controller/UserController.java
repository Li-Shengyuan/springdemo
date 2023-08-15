package com.lsy.ibook.controller;

import com.lsy.ibook.bean.User;
import com.lsy.ibook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    private UserService userService;

    /**
     * 新增 用户
     */
    @RequestMapping("/user")
    public boolean doAdd(User user){
        // 如果用户名已被注册
        if(userService.selectByYhm(user.getYhm())){
            return false;
        }
        // 用户名没被注册，则新增
        else{
            user.setYhsf("3"); // 新注册用，身份默认为 3 （普通用户）
            return userService.addUser(user);
        }
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/user/{id}")
    public boolean doDel(@PathVariable int id){
        return userService.deleteById(id);
    }

    /**
     * 查询多个用户
     */
    @GetMapping("/user")
    public List<User> doList(User user){
        return userService.listUsers(user);
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/user")
    public boolean doUpdate(User user) {
        System.out.println("------------"+user);
        return userService.updateUser(user);
    }
}
