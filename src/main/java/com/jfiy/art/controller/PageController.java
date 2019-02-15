package com.jfiy.art.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller

public class PageController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
    @GetMapping(value = "/retrieve")
    public String retrieve() {
        return "retrieve";
    }
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    @GetMapping(value = "/modify")
    public String modify() {
        return "modify";
    }
    @GetMapping(value = "/star")
    public String star() {
        return "star";
    }
    @GetMapping(value = "/review")
    public String review() {
        return "review";
    }
    @GetMapping(value = "/type")
    public String type() {
        return "type";
    }

}