package com.jfiy.art.service.serviceImpl;

import com.jfiy.art.dao.UserMapper;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

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
        if(session.getAttribute("user")==null){
            session.setAttribute("user",user);
        }
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
            userMapper.addArtist(user.getId()+"");
            session.setAttribute("user",user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("用户名不可用");
        }
    }

    @Override
    public List<User> getUserList(HashMap<String,Object> queryMap) {
        if(queryMap.get("sex").equals("all")){
            queryMap.remove("sex");
        }else if(queryMap.get("sex").equals("mal")){
            queryMap.put("sex",0);
        }else{
            queryMap.put("sex",1);
        }
        if(queryMap.get("auth").equals("all")){
            queryMap.remove("auth");
        }
        if(queryMap.get("order").equals("default")){
            queryMap.remove("order");
        }
        if(queryMap.get("isArtist").equals("default")){
            queryMap.remove("isArtist");
        }
        if(queryMap.get("id").equals("")){
            queryMap.remove("id");
        }
        if(queryMap.get("name").equals("")){
            queryMap.remove("name");
        }
        return userMapper.findUserList(queryMap);
    }

    @Override
    public void updateUser(HashMap<String, Object> queryMap) {
        userMapper.updateUser(queryMap);
    }

    @Override
    public List<HashMap> getUserSugByIdOrName(String keyword) {
        return userMapper.findUserForSug(keyword);
    }

    @Override
    public void updateArtist(HashMap hashMap) {
        userMapper.updateArtist(hashMap);
    }

    @Override
    public HashMap getArtistById(String id) {
        return userMapper.getArtistById(id);
    }

    @Override
    public List<HashMap> getArtist(HashMap hashMap) {
        return userMapper.getArtist(hashMap);
    }

    @Override
    public List<HashMap> srhArtist(String s) {
        return userMapper.srhArtist(s);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }
}
