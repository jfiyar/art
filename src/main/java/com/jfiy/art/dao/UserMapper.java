package com.jfiy.art.dao;


import com.jfiy.art.entity.User;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UserMapper {

    User findUserByNameAndPwd(User user);
    void addUser(User user);




}
