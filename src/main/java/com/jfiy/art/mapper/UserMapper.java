package com.jfiy.art.mapper;


import com.jfiy.art.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findUserInfo();
}
