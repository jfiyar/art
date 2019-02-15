package com.jfiy.art.service;


import com.jfiy.art.entity.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface UserService {
    HashMap<String, Object> login(HttpSession session, String name, String pwd) throws Exception;
    User register(HttpSession session, String name, String pwd) throws Exception;
}
