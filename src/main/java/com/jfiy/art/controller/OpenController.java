package com.jfiy.art.controller;

import com.jfiy.art.dao.UserDao;
import com.jfiy.art.mapper.UserMapper;
import com.jfiy.art.model.User;
import com.jfiy.art.service.ApiService;
import com.jfiy.art.service.UserService;
import com.jfiy.art.service.serviceImpl.ApiServiceImpl;
import com.jfiy.art.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/open")
public class OpenController {
//    @Autowired
//    UserMapper userMapper;
    @Autowired
    UserDao userDao;

    private UserService userService=new UserServiceImpl(userDao);

    private ApiService apiService=new ApiServiceImpl();
    @GetMapping(value = "/login")
    public String Login( HttpSession session,String username,String password){
        User user=new User();
        user.setName(username);
        user.setPassword(password);
        return userService.getUser(user);
    }
//    @GetMapping(value = "/register")
//    public String Register(String username,String password) {
//        User user=new User();
//        user.setName(username);
//        user.setPassword(password);
//        userMapper.InsertUser(user);
//        System.out.println(user.getId());
//        return ""+user.getId();
//    }
}
