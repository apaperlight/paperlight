package com.paper.controller;

import com.paper.entity.User;
import com.paper.service.UserService;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${server.port}")
    int port;
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id){
        System.out.println("我被调用了+" + port);
        return userService.getUserById(id);
    }
}
