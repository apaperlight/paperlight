package com.paper.controller;

import com.paper.entity.User;
import com.paper.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
