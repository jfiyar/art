package com.jfiy.art.service.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.jfiy.art.dao.ArtworkMapper;
import com.jfiy.art.entity.Artwork;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.ArtworkService;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("ArtworkService")
public class ArtworkServiceImpl implements ArtworkService {
    @Autowired
    ArtworkMapper artworkMapper;
    @Override
    public List<Artwork> getArtworkByUser(User user) {
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
            put("info",artworkMapper.findArtInfoById(id));
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
        System.out.println("上传的文件名为：" + fileName);
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
        System.out.println(offset);
        return artworkMapper.findArtRecommendList(offset);
    }
}
