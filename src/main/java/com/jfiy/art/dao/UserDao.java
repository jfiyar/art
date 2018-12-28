package com.jfiy.art.dao;

import com.jfiy.art.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User getUser(User user);
}
