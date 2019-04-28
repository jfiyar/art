package com.jfiy.art.controller;


import com.jfiy.art.entity.User;
import com.jfiy.art.service.ArtworkService;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller

public class PageController implements ErrorController {
    private final
    ArtworkService artworkService;
    private final UserService userService;

    @Autowired
    public PageController(ArtworkService artworkService,UserService userService) {
        this.artworkService = artworkService;
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(Model model,HttpSession session) {
        User user=(User) session.getAttribute("user");
        if(user!=null&&user.getAuth().equals("admin")){
            model.addAttribute("sys",artworkService.getSysInfo());
            return "admin/index";
        }
        model.addAttribute("art",artworkService.getArtworkByUser(user));
        model.addAttribute("byScore",artworkService.getArtworkByScore(0,5));
        model.addAttribute("byTime",artworkService.getArtworkByTime(0,5));
        model.addAttribute("topArtist",artworkService.findTopArtist());
        if(user!=null){
            HashMap artist=artworkService.getArtist(user.getId()+"");
            if(artist!=null&&artist.get("birthday")!=null){
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data= simpleDateFormat.format((Date)artist.get("birthday"));
                String[] d=data.split(" ");
                artist.put("birthday",d[0]);
            }
            model.addAttribute("id",user.getId());
            model.addAttribute("user",userService.getArtistById(user.getId()+""));
            model.addAttribute("myArt",artworkService.getArtworkByUser(user));
            model.addAttribute("artist",artist);
        }
        return "index";
    }
    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }
    @GetMapping(value = "/artist-register")
    public String artistRegister() {
        return "artist-register";
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
    @GetMapping("/art/{id}")
    public String artInfo(@PathVariable String id,Model model) {
        HashMap info=artworkService.getArtInfoById(id);
        if(info!=null){
            artworkService.scoreIncr(id);
            model.addAttribute("info",info);
            model.addAttribute("media",artworkService.getMediaListByArtId(id));
            model.addAttribute("commend",artworkService.getCommentListByArtId(id));
            return "art";
        }else {
            return "reviewing";
        }

    }

    @GetMapping("/artist/{id}")
    public String artist(@PathVariable String id,Model model) {
        model.addAttribute("id",id);
        model.addAttribute("user",userService.getArtistById(id));
        User user=new User();
        user.setId(Long.parseLong(id));
        model.addAttribute("art",artworkService.getArtworkByUser(user));
        return "artist";
    }
    @GetMapping("/srh")
    public String srh(String word,Model model,String type) {
        model.addAttribute("word",word);
        model.addAttribute("type",type);
        if(word.equals("")){
            return "srh";
        }
        switch (type) {
            case "all":
                model.addAttribute("user", userService.srhArtist("%" + word + "%"));
                model.addAttribute("art", artworkService.srhArt("%" + word + "%"));
                break;
            case "user":
                model.addAttribute("user", userService.srhArtist("%" + word + "%"));
                break;
            case "art":
                model.addAttribute("art", artworkService.srhArt("%" + word + "%"));
                break;
            default:
                model.addAttribute("user", userService.srhArtist("%" + word + "%"));
                model.addAttribute("art", artworkService.srhArt("%" + word + "%"));
                break;
        }
        return "srh";
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