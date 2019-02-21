package com.jfiy.art.controller;


import com.alibaba.fastjson.JSON;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller

public class PageController implements ErrorController {
    @Autowired
    ArtworkService artworkService;
    @GetMapping(value = "/")
    public String index(Model model,HttpSession session) {
        User user=(User) session.getAttribute("user");
        if(user!=null&&user.getAuth().equals("admin")){
            return "admin/index";
        }
        System.out.println(JSON.toJSONString(artworkService.getArtworkByScore(0,4)));
        model.addAttribute("byScore",artworkService.getArtworkByScore(0,4));
        model.addAttribute("byTime",artworkService.getArtworkByTime(0,4));
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

    @GetMapping(value = "/artwork")
    public String artwork(Model model,HttpSession session) {
        model.addAttribute("list",artworkService.getArtworkByUser((User)session.getAttribute("user")));
        return "artwork";
    }
    @GetMapping(value = "/error")
    public String forbidden(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 403){
            return getErrorPath();
        }
        return null;
    }
    @Override
    public String getErrorPath() {
        return "403";
    }
}