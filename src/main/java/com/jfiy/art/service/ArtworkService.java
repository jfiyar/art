package com.jfiy.art.service;

import com.jfiy.art.entity.Artwork;
import com.jfiy.art.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface ArtworkService {
    List<Artwork> getArtworkByUser(User user);
    List<HashMap> getArtworkByScore(int offset,int limit);
    List<HashMap> getArtworkByTime(int offset,int limit);
    List<HashMap> getArtList(HashMap map);
    HashMap getArtById(int id);
    void updateArtworkInfo(HashMap hashMap);
    void deleteArtworkMedia(String id);
    void uploadArtworkMedia(String id,MultipartFile multipartFile);

    List getRecommendList(int offset);
}
