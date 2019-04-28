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
    public List<com.jfiy.art.entity.User> list(@RequestParam HashMap<String,Object> queryMap, int offset, int limit){
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
    public List<HashMap> art(@RequestParam HashMap<String,Object> queryMap, int offset, int limit){
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
    public List<HashMap> getUserSug(String keyword){
        return userService.getUserSugByIdOrName(keyword);
    }

    @PostMapping("/art/update")
    public void updateArtInfo(@RequestParam HashMap hashMap,int id,String delArr){
        hashMap.put("id",id);
        artworkService.updateArtworkInfo(hashMap);
        artworkService.deleteArtworkMedia(delArr);
    }
    @PostMapping("/art/upload")
    public void uploadArtMedia(@RequestParam MultipartFile file, HttpServletRequest request){
        String id=request.getParameter("artwork_id");
        artworkService.uploadArtworkMedia(id,file);
    }
    @PostMapping("/artist")
    public List<HashMap> review(@RequestParam HashMap<String, Object> hashMap, int offset, int limit){
        hashMap.put("offset",offset);
        hashMap.put("limit",limit);
        return userService.getArtist(hashMap);
    }
    @GetMapping("/artist/update")
    public void updateArtist(@RequestParam HashMap hashMap,String review,int user_id){
        if(review!=null&&review.equals("1")){
            userService.updateUser(new HashMap<String,Object>(){{
                put("id",user_id);
                put("isArtist",review);
            }});
        }
        userService.updateArtist(hashMap);
    }
    @GetMapping("/art/type")
    public List<HashMap> artType(){
        return artworkService.findAllType();
    }
    @GetMapping("/art/type/update")
    public void artTypeUpdate(@RequestParam HashMap hashMap){
        artworkService.updateArtType(hashMap);
    }
    @GetMapping("/art/type/add")
    public HashMap typeAdd(@RequestParam HashMap hashMap){
        artworkService.addArtType(hashMap);
        return hashMap;
    }
    @GetMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.delete(id);
    }
    @GetMapping("/art/type/remove")
    public void artTypeRemove(@RequestParam HashMap hashMap){
        artworkService.removeArtType(hashMap);
    }
}
