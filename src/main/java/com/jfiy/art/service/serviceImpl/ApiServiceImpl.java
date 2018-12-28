package com.jfiy.art.service.serviceImpl;

import com.jfiy.art.dao.UserDao;
import com.jfiy.art.model.User;
import com.jfiy.art.service.ApiService;
import com.jfiy.art.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    UserDao userDao;
    @Override
    public String Login(HttpSession session, String username,String password) {
        User user=new User();
        String restJsonString;
        user.setName(username);
        user.setPassword(password);
        user = userDao.getUser(user);
        if(user.getId()==null){//登录失败
            restJsonString=ApiUtil.RestJson("密码错误");
        }else {//登录成功
            session.setAttribute("user",user);
            restJsonString=ApiUtil.RestJson(new HashMap<String,Object>(){
                {
                    put("message","登录成功");
                }
            });
        }
        return restJsonString;
    }

    @Override
    public String Register(String username, String password) {
        return null;
    }
}
