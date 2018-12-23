package com.jfiy.art.controller;

import com.jfiy.art.mapper.UserMapper;
import com.jfiy.art.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    UserMapper userMapper;
    @GetMapping(value = "/login")
    public String Login(User user, HttpSession session){
        user.setName("123");
        session.setAttribute("user",user);
        return "234";
    }
    @GetMapping(value = "/register")
    public String Register(String username,String password) {
        User user=new User();
        user.setName(username);
        user.setPassword(password);
        userMapper.InsertUser(user);
        System.out.println(user.getId());
        return ""+user.getId();
    }
}
