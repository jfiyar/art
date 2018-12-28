package com.jfiy.art.service.serviceImpl;

import com.jfiy.art.dao.UserDao;
import com.jfiy.art.model.User;
import com.jfiy.art.service.UserService;
import com.jfiy.art.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String getUser(User user) {
        User finalUser = userDao.getUser(user);
        return ApiUtil.RestJson(new HashMap<String,String>(){
            {
                put("name", finalUser.getName());
            }
        });
    }
}
