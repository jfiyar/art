package com.jfiy.art.entity;


public class User {

  private long id;
  private String name;
  private String pwd;
  private String auth;
  private String avatar;
  private long sex;
  private long isArtist;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public String getAuth() {
    return auth;
  }

  public void setAuth(String auth) {
    this.auth = auth;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public long getIsArtist() {
    return isArtist;
  }

  public void setIsArtist(long isArtist) {
    this.isArtist = isArtist;
  }

}
