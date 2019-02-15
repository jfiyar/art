package com.jfiy.art.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/api")
public class ApiController {
    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }
}
