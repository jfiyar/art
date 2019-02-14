package com.jfiy.art.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PageController {

    @GetMapping(value = "/")
    public String Index() {
        return "index";
    }
    @GetMapping(value = "/register")
    public String Register() {
        return "register";
    }
}