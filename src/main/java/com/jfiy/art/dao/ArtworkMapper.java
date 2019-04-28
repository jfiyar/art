package com.jfiy.art.dao;


import com.jfiy.art.entity.Art;
import com.jfiy.art.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface ArtworkMapper {

    List<HashMap> findArtworkByUser(User user);
    List<HashMap> findArtworkByScore(HashMap map);
    List<HashMap> findArtworkByTime(HashMap map);
    List<HashMap> findArtList(HashMap map);
    List<HashMap> findArtMediaById(int id);
    HashMap findArtInfoById(int id);
    void addArtMedia(HashMap hashMap);
    void updateArtMedia(HashMap hashMap);
    void removeArtMediaById(String id);
    void updateArt(HashMap hashMap);
    List<HashMap> findArtRecommendList(int offset);

    void addArtwork(HashMap hashMap);

    HashMap getArtInfoById(String id);
    List<HashMap> getMediaListByArtId(String id);
    List<HashMap> getMediaListByArtIntId(int id);
    List<HashMap> getCommentListBuArtId(String id);

    void addRecommend(HashMap hashMap);

    HashMap<String,Object> getArtistById(String userId);

    void insertArtist(HashMap<String, Object> stringObjectHashMap);

    void updateArtistByUserId(HashMap<String, Object> stringObjectHashMap);

    void removeCommend(String id);

    void scoreIncr(String id);

    HashMap getSysInfo();

    List<HashMap> srhArt(String s);

    List<HashMap> findAllType();

    void updateArtType(HashMap hashMap);

    void addArtType(HashMap hashMap);

    void removeArtType(HashMap hashMap);

    List<Art> findArtByType(HashMap hashMap);

    List<HashMap> findTopArtist();
}
