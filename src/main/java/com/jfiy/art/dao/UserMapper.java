package com.jfiy.art.dao;


import com.jfiy.art.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    User findUserByUsername(String username);

    void updateUserByUsername(User user);

    void deleteUserByUsername(String username);

    void saveUser(User user);

    List<User> getUserList();
}
