package com.jfiy.art.mapper;


import com.jfiy.art.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findUserInfo();

    @Insert("insert into user(name,password) values(#{name},#{password})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    public void InsertUser(User user);




    @Select("select * from user where name=#{name} and password=#{password}")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
    })
    public User selectUser(User user);
}
