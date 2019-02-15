package com.jfiy.art.service.serviceImpl;

import com.jfiy.art.dao.UserMapper;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public HashMap<String, Object> login(HttpSession session, String name, String pwd) throws Exception {
        User user=new User();
        user.setName(name);
        user.setPwd(pwd);
        user=userMapper.findUserByNameAndPwd(user);
        session.setAttribute("user",user);
        HashMap<String,Object> map=new HashMap<>();
        if(user!=null){
            map.put("id", user.getId());
            map.put("name", user.getName());
            map.put("auth", user.getAuth());
            map.put("avatar", user.getAvatar());
        }else {
            throw new Exception("账号或密码错误");
        }
        return map;
    }

    @Override
    public User register(HttpSession session, String name, String pwd) throws Exception {
        User user=new User();
        user.setName(name);
        user.setPwd(pwd);
        try{
            userMapper.addUser(user);
            user = userMapper.findUserByNameAndPwd(user);
            session.setAttribute("user",user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("用户名不可用");
        }
    }
}
