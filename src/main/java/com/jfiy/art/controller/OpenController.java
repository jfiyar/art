package com.jfiy.art.controller;


import com.jfiy.art.dao.ArtworkMapper;
import com.jfiy.art.entity.Art;
import com.jfiy.art.service.ArtworkService;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/open")
public class OpenController {
    private final UserService userService;
    private final ArtworkService artworkService;

    @Autowired
    public OpenController(UserService userService, ArtworkService artworkService) {
        this.userService = userService;
        this.artworkService = artworkService;
    }

    @PostMapping("/login")
    public Object login(HttpSession session,String name,String pwd) throws Exception {
        return userService.login(session,name,pwd);
    }
    @PostMapping("/register")
    public Long register(HttpSession session,String username,String password) throws Exception {
        return userService.register(session,username,password).getId();
    }
    @PostMapping("/artist-register")
    public void artistRegister(HttpSession session,String username,String password,String nation,String birthday,String profession,String info) throws Exception {
        Long id= userService.register(session,username,password).getId();
        userService.updateArtist(new HashMap<String,Object>(){{
            put("user_id",id);
            put("nation",nation);
            put("profession",profession);
            put("birthday",birthday);
            put("info",info);
            put("review",0);
        }});
    }
    @GetMapping("/art/list")
    public List recommendList(int offset){
        return artworkService.getRecommendList(offset);
    }

    @GetMapping("/art/type")
    public List<HashMap> artType(){
        return artworkService.findAllType();
    }
    @GetMapping("/art/byType")
    public List<Art> getAtyByType(String type){
        String[] types=type.split(",");
        return artworkService.findArtByType(types);
    }
    @GetMapping("/artist/top")
    public List<HashMap> topArtist(){
        return artworkService.findTopArtist();
    }

}
