package com.jfiy.art.service;


import com.jfiy.art.entity.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    HashMap<String, Object> login(HttpSession session, String name, String pwd) throws Exception;
    User register(HttpSession session, String name, String pwd) throws Exception;
    List<User> getUserList(HashMap<String,Object> queryMap);
    List<HashMap> getUserSugByIdOrName(String keyword);
    //更新艺术家
    void updateArtist(HashMap hashMap);
    //查看艺术家
    HashMap getArtistById(String id);
    //查看艺术家列表
    List<HashMap> getArtist(HashMap hashMap);
    //查询艺术家
    List<HashMap> srhArtist(String s);
    //更新用户信息
    void updateUser(HashMap<String,Object> queryMap);

    void delete(int id);
}
