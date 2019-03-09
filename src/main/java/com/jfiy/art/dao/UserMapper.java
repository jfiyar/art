package com.jfiy.art.dao;


import com.jfiy.art.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface UserMapper {

    User findUserByNameAndPwd(User user);
    void addUser(User user);
    List<User> findUserList(HashMap queryMap);
    void updateUser(HashMap queryMap);
    List<HashMap> findUserForSug(String keyword);


    void updateArtist(HashMap hashMap);

    void addArtist(String id);

    HashMap getArtistById(String id);
}
