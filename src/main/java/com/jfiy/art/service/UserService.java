package com.jfiy.art.service;


import com.mysql.cj.Session;

import javax.servlet.http.HttpSession;

public interface UserService {
    public String login(HttpSession session,String name, String pwd);
}
