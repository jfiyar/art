package com.jfiy.art.controller;


import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/open")
public class OpenController {
    @Autowired UserService userService;
    @PostMapping("/login")
    public Object login(HttpSession session,String name,String pwd) throws Exception {
        return userService.login(session,name,pwd);
    }
    @PostMapping("/register")
    public Long register(HttpSession session,String username,String password) throws Exception {
        return userService.register(session,username,password).getId();
    }
}
