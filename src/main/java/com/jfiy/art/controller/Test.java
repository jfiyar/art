package com.jfiy.art.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller

public class Test {

    @GetMapping(value = "/")
    public String Index(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            return "index";
        }
        return "homepage";
    }
    @GetMapping(value = "/login.do")
    public String Login(){
        return "123";
    }
    @GetMapping(value = "/reg")
    public String Reg(){
        return "123";
    }
}