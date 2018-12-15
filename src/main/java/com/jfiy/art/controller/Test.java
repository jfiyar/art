package com.jfiy.art.controller;

import com.jfiy.art.model.User;
import com.jfiy.art.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Test {

    private final UserService userService;

    @Autowired
    public Test(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/")
    public String hello() {
        List<User> list=userService.getUserInfo();
        for (User u:list) {
            System.out.println(u.getName());
        }
        return "hello,Spring Boot";
    }
}