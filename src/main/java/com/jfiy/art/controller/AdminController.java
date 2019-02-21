package com.jfiy.art.controller;


import com.jfiy.art.service.ArtworkService;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
//        System.out.println(queryMap.get("sex"));
        if(queryMap.get("sex")!=null){
            queryMap.put("sex",Integer.valueOf((String) queryMap.get("sex")));
        }
//        System.out.println(JSON.toJSONString(queryMap));
        userService.updateUser(queryMap);
    }

    @PostMapping("/art/list")
    public List art(@RequestParam HashMap<String,Object> queryMap, int offset, int limit){
        queryMap.put("offset",offset);
        queryMap.put("limit",limit);
//        System.out.println(JSON.toJSONString(queryMap));
        return artworkService.getArtList(queryMap);
    }

    @PostMapping("/art/info")
    public HashMap getArtInfo(int id){
//        System.out.println(id);
        return artworkService.getArtById(id);
    }

    @GetMapping("/user/sug")
    public List getUserSug(String keyword){
        return userService.getUserSugByIdOrName(keyword);
    }

    @PostMapping("/art/update")
    public void updateArtInfo(@RequestParam HashMap hashMap,String delArr){
        artworkService.updateArtworkInfo(hashMap);
        artworkService.deleteArtworkMedia(delArr);
    }
    @PostMapping("/art/upload")
    public void uploadArtMedia(@RequestParam MultipartFile file, HttpServletRequest request){
        String id=request.getParameter("artwork_id");
        System.out.println(id);
        System.out.println(file.getOriginalFilename());
        artworkService.uploadArtworkMedia(id,file);
    }
}
