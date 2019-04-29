package com.jfiy.art.service;

import com.jfiy.art.entity.Art;
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
    //上传作品图片
    void uploadArtworkMedia(String id,MultipartFile multipartFile);

    //获取评论列表
    List getRecommendList(int offset);
    //发布作品
    HashMap addArt(HashMap hashMap);

    //获取艺术作品信息
    HashMap getArtInfoById(String id);
    //获取作品图片
    List<HashMap> getMediaListByArtId(String id);
    List<HashMap> getCommentListByArtId(String id);

    //发布评论
    void addRecommend(HashMap hashMap);
    //上传艺术家头像
    void uploadArtistAvatar(String s, MultipartFile file);

    //
    HashMap getArtist(String id);

    void removeCommend(String id);

    void scoreIncr(String id);

    HashMap getSysInfo();

    List<HashMap> srhArt(String s);
    List<HashMap> findAllType();

    void updateArtType(HashMap hashMap);

    void addArtType(HashMap hashMap);

    void removeArtType(HashMap hashMap);

    List<Art> findArtByType(String[] types);

    List<HashMap> findTopArtist();
}
