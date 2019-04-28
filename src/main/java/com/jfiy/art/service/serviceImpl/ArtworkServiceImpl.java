package com.jfiy.art.service.serviceImpl;

import com.jfiy.art.dao.ArtworkMapper;
import com.jfiy.art.entity.Art;
import com.jfiy.art.entity.Artwork;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service("ArtworkService")
public class ArtworkServiceImpl implements ArtworkService {
    @Autowired
    ArtworkMapper artworkMapper;
    @Override
    public List<HashMap> getArtworkByUser(User user) {
//        System.out.println(user.getName());
        return artworkMapper.findArtworkByUser(user);
    }

    @Override
    public List<HashMap> getArtworkByScore(int offset, int limit) {
        return artworkMapper.findArtworkByScore(new HashMap<String,Integer>(){{
            put("offset",offset);
            put("limit",limit);
        }});
    }

    @Override
    public List<HashMap> getArtworkByTime(int offset, int limit) {
        return artworkMapper.findArtworkByTime(new HashMap<String,Integer>(){{
            put("offset",offset);
            put("limit",limit);
        }});
    }

    @Override
    public List<HashMap> getArtList(HashMap map) {
        return artworkMapper.findArtList(map);
    }

    @Override
    public HashMap getArtById(int id) {
        return new HashMap<String,Object>(){{
            put("media",artworkMapper.findArtMediaById(id));
            put("info",artworkMapper.getArtInfoById(id+""));
        }};
    }

    @Override
    public void updateArtworkInfo(HashMap hashMap) {
        hashMap.remove("delArr");
        if(hashMap.size()==1){
            return;
        }
        artworkMapper.updateArt(hashMap);
    }

    @Override
    public void deleteArtworkMedia(String delArr) {
        if(delArr==null){
            return;
        }
        String[] dels=delArr.split(",");
        System.out.println(Arrays.toString(dels));
        for (String del :dels) {
            artworkMapper.removeArtMediaById(del);
        }
    }

    @Override
    public void uploadArtworkMedia(String id,MultipartFile file) {
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName;
        if (fileName != null) {
            suffixName = fileName.substring(fileName.lastIndexOf("."));
        }else {
            return;
        }
        // 文件上传后的路径
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(path.getAbsolutePath(),"static/upload/");
            String filePath = upload.getAbsolutePath()+"/";
//            System.out.println(upload.getAbsolutePath());
            HashMap<String,Object> map=new HashMap<String,Object>(){{
                put("artwork_id",id);
                put("type","image");
                put("url","loading...");
            }};
            artworkMapper.addArtMedia(map);
            System.out.println(map.toString());
            String url= map.get("id").toString() + suffixName;
            File dest = new File(filePath +url);
            try {
                map.put("url","/upload/"+url);
                file.transferTo(dest);
                map.remove("artwork_id");
                map.remove("type");
                artworkMapper.updateArtMedia(map);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List getRecommendList(int offset) {
        return artworkMapper.findArtRecommendList(offset);
    }

    @Override
    public HashMap addArt(HashMap hashMap) {
        artworkMapper.addArtwork(hashMap);
        return hashMap;
    }

    @Override
    public HashMap getArtInfoById(String id) {
        return artworkMapper.getArtInfoById(id);
    }

    @Override
    public List<HashMap> getMediaListByArtId(String id) {
        return artworkMapper.getMediaListByArtId(id);
    }

    @Override
    public List<HashMap> getCommentListByArtId(String id) {
        return artworkMapper.getCommentListBuArtId(id);
    }

    @Override
    public void addRecommend(HashMap hashMap) {
        artworkMapper.addRecommend(hashMap);
    }

    @Override
    public void uploadArtistAvatar(String userId, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        if(fileName==null){
            return;
        }
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(path.getAbsolutePath(),"static/upload/");
            String filePath = upload.getAbsolutePath()+"/";
            String url= userId+Math.random() + suffixName;
            if(artworkMapper.getArtistById(userId)==null){
                artworkMapper.insertArtist(new HashMap<String,Object>(){{
                    put("user_id",userId);
                }});
            }
            artworkMapper.updateArtistByUserId(new HashMap<String,Object>(){{
                put("avatar",url);
                put("user_id",userId);
            }});

            File dest = new File(filePath +url);
            try {
                file.transferTo(dest);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap getArtist(String id) {
        return artworkMapper.getArtistById(id);
    }

    @Override
    public void removeCommend(String id) {
        artworkMapper.removeCommend(id);
    }

    @Override
    public void scoreIncr(String id) {
        artworkMapper.scoreIncr(id);
    }

    @Override
    public HashMap getSysInfo() {
        return artworkMapper.getSysInfo();
    }

    @Override
    public List<HashMap> srhArt(String s) {
        return artworkMapper.srhArt(s);
    }

    @Override
    public List<HashMap> findAllType() {
        return artworkMapper.findAllType();
    }

    @Override
    public void updateArtType(HashMap hashMap) {
        artworkMapper.updateArtType(hashMap);
    }

    @Override
    public void addArtType(HashMap hashMap) {
        artworkMapper.addArtType(hashMap);
    }

    @Override
    public void removeArtType(HashMap hashMap) {
        artworkMapper.removeArtType(hashMap);
    }

    @Override
    public List<Art> findArtByType(String[] types) {
        return artworkMapper.findArtByType(new HashMap(){{
            put("list",types);
        }});
    }

    @Override
    public List<HashMap> findTopArtist() {
        return artworkMapper.findTopArtist();
    }
}
