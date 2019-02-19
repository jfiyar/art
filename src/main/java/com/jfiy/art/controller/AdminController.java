package com.jfiy.art.controller;


import com.alibaba.fastjson.JSON;
import com.jfiy.art.dao.ArtworkMapper;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.ArtworkService;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ArtworkService artworkService;
    @PostMapping("/user/list")
    public List list(@RequestParam HashMap<String,Object> queryMap,int offset,int limit){
        queryMap.put("offset",offset);
        queryMap.put("limit",limit);
        return userService.getUserList(queryMap);
    }
    @PostMapping("/user/update")
    public void update(@RequestParam HashMap<String,Object> queryMap,int id){
        queryMap.put("id",id);
        System.out.println(queryMap.get("sex"));
        if(queryMap.get("sex")!=null){
            queryMap.put("sex",Integer.valueOf((String) queryMap.get("sex")));
        }
        System.out.println(JSON.toJSONString(queryMap));
        userService.updateUser(queryMap);
    }

    @PostMapping("/art/list")
    public List art(@RequestParam HashMap<String,Object> queryMap, int offset, int limit){
        queryMap.put("offset",offset);
        queryMap.put("limit",limit);
        System.out.println(JSON.toJSONString(queryMap));
        return artworkService.getArtList(queryMap);
    }
}
