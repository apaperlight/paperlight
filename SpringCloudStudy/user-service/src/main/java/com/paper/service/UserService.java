package com.paper.service;

import com.paper.entity.User;
import com.paper.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }
}
