package com.jfiy.art.service.Impl;

import com.jfiy.art.mapper.UserMapper;
import com.jfiy.art.model.User;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserInfo() {
        return userMapper.findUserInfo();
    }
}
