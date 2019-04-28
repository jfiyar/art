package com.jfiy.art.controller;


import com.jfiy.art.entity.User;
import com.jfiy.art.service.ArtworkService;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


@RestController
@RequestMapping("/api")
public class ApiController {
    private final
    ArtworkService artworkService;
    private final UserService userServices;

    @Autowired
    public ApiController(ArtworkService artworkService,UserService userServices) {
        this.artworkService = artworkService;
        this.userServices = userServices;
    }

    @PostMapping("/change_password")
    public void changePwd(@RequestParam HashMap<String, Object> hashMap, HttpSession session, String oldPwd){
        User user=(User)session.getAttribute("user");
        if(oldPwd.equals(user.getPwd())){
            hashMap.put("id",user.getId());
            userServices.updateUser(hashMap);
        }else{
            throw new Error("旧密码错误");
        }
    }
    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file,HttpSession session){
        User user=(User) session.getAttribute("user");
        artworkService.uploadArtworkMedia(user.getId()+"",file);
        return null;
    }
    @PostMapping("/art/add")
    public HashMap addArt(@RequestParam HashMap<String, Object> hashMap, HttpSession session){
        User user=(User)session.getAttribute("user");
        hashMap.put("artist",user.getId());
        return artworkService.addArt(hashMap);
    }
    @PostMapping("/media/add")
    public void addMedia(@RequestParam MultipartFile file, HttpServletRequest request){
        String id=request.getParameter("id");
        artworkService.uploadArtworkMedia(id,file);
    }

    @PostMapping("/commend")
    public void addRecommend(@RequestParam HashMap<String,Object> hashMap,HttpSession session){
        User user=(User)session.getAttribute("user");
        hashMap.put("user",user.getId());
        artworkService.addRecommend(hashMap);
    }

    @PostMapping("/commend/delete")
    public void removeCom(String id){
        System.out.println(id);
        artworkService.removeCommend(id);
    }

    @PostMapping("/artist/avatar")
    public void artistAvatar(@RequestParam MultipartFile file, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        artworkService.uploadArtistAvatar(user.getId()+"",file);
    }

    @PostMapping("/user")
    public void updateUserInfo(@RequestParam HashMap<String,Object> hashMap,HttpSession session) throws ParseException {
        User user=(User)session.getAttribute("user");
        String newUsername=(String) hashMap.get("username");
        String newSex=(String) hashMap.get("sex");
        String newBirthday=(String) hashMap.get("birthday");
        if(newUsername!=null&&!newUsername.equals(user.getName())){
            userServices.updateUser(new HashMap<String, Object>(){{
                put("id",user.getId());
                put("name",newUsername);
            }});
            user.setName(newUsername);
            session.setAttribute("user",user);
        }
        if(newSex!=null&&!newSex.equals(user.getSex()+"")){
            userServices.updateUser(new HashMap<String, Object>(){{
                put("id",user.getId());
                put("sex",newSex);
            }});
            user.setSex(Long.parseLong(newSex));
            session.setAttribute("user",user);
        }

        if(newBirthday!=null){
            SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date newBirthdayDate=simpleDateFormat.parse(newBirthday);
            SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            hashMap.put("birthday",sdf.format(newBirthdayDate));
        }
        hashMap.put("user_id",user.getId());

        userServices.updateArtist(hashMap);
    }
}
