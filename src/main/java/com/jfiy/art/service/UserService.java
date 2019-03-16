package com.jfiy.art.service;


import com.jfiy.art.entity.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    HashMap<String, Object> login(HttpSession session, String name, String pwd) throws Exception;
    User register(HttpSession session, String name, String pwd) throws Exception;
    List<User> getUserList(HashMap<String,Object> queryMap);
    void updateUser(HashMap<String,Object> queryMap);
    List<HashMap> getUserSugByIdOrName(String keyword);

    void updateArtist(HashMap hashMap);

    HashMap getArtistById(String id);

    List<HashMap> getArtist(HashMap hashMap);

    List<HashMap> srhArtist(String s);
}
