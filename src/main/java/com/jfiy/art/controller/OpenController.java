package com.jfiy.art.controller;


import com.jfiy.art.service.UserService;
import com.jfiy.art.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/open")
public class OpenController {
    private UserService userService = new UserServiceImpl();
    @RequestMapping("/login")
    public String login(HttpSession session){
        return userService.login(session,"123","123");
    }
}
