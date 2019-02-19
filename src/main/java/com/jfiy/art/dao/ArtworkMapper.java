package com.jfiy.art.dao;


import com.jfiy.art.entity.Artwork;
import com.jfiy.art.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface ArtworkMapper {

    List<Artwork> findArtworkByUser(User user);
    List<Artwork> findArtworkByScore(HashMap map);
    List<Artwork> findArtworkByTime(HashMap map);
    List<Artwork> findArtList(HashMap map);

}
