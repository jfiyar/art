package com.jfiy.art.entity;


import org.apache.ibatis.type.Alias;


@Alias("user")
public class User {

    private int id;
    private String name;
    private String pwd;

    public User(String user_name, String user_password) {
        this.name = user_name;
        this.pwd = user_password;
    }

    public User(int id, String user_name, String user_password) {
        this.id = id;
        this.name = user_name;
        this.pwd = user_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
