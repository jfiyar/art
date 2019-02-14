package com.jfiy.art.service.serviceImpl;

import com.jfiy.art.dao.UserMapper;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(HttpSession session,String name, String pwd) {
        User user=userMapper.findUserByNameAndPwd(name,pwd);
        if(user!=null){
            session.setAttribute("user",user);
            return "ok";
        }
        return "no";
    }
}
