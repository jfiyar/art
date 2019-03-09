package com.jfiy.art.entity;


public class Artwork {

  private long id;
  private String name;
  private long artist;
  private String info;
  private long review;
  private double score;
  private String avatar;


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


  public long getArtist() {
    return artist;
  }

  public void setArtist(long artist) {
    this.artist = artist;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }


  public long getReview() {
    return review;
  }

  public void setReview(long review) {
    this.review = review;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
