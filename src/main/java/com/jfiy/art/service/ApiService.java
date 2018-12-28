package com.jfiy.art.service;

import com.jfiy.art.model.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpSession;

public interface ApiService {
    public String Login(HttpSession session,String username,String password);
    public String Register(String username,String password);
}
