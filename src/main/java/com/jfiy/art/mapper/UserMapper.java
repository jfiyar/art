package com.jfiy.art.mapper;


import com.jfiy.art.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findUserInfo();

    @Insert("insert into user(name,password) values(#{name},#{password})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    public void InsertUser(User user);
}
