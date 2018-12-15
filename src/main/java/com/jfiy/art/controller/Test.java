package com.jfiy.art.controller;

import com.jfiy.art.model.User;
import com.jfiy.art.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Test {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/")
    public String hello() {
        var List=userService.getUserInfo();
        for (User u:List) {
            System.out.println(u.getName());
        }
        return "hello,Spring Boot";
    }
}