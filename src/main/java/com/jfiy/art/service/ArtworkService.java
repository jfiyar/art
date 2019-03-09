package com.jfiy.art.service;

import com.jfiy.art.entity.Artwork;
import com.jfiy.art.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface ArtworkService {
    List<HashMap> getArtworkByUser(User user);
    List<HashMap> getArtworkByScore(int offset,int limit);
    List<HashMap> getArtworkByTime(int offset,int limit);
    List<HashMap> getArtList(HashMap map);
    HashMap getArtById(int id);
    void updateArtworkInfo(HashMap hashMap);
    void deleteArtworkMedia(String id);
    void uploadArtworkMedia(String id,MultipartFile multipartFile);

    List getRecommendList(int offset);

    HashMap addArt(HashMap hashMap);

    HashMap getArtInfoById(String id);

    List<HashMap> getMediaListByArtId(String id);
    List<HashMap> getCommentListByArtId(String id);

    void addRecommend(HashMap hashMap);

    void uploadArtistAvatar(String s, MultipartFile file);

    HashMap getArtist(String id);

    void removeCommend(String id);

    void scoreIncr(String id);

    HashMap getSysInfo();
}
