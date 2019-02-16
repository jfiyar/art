package com.jfiy.art.service.serviceImpl;

import com.jfiy.art.dao.ArtworkMapper;
import com.jfiy.art.entity.Artwork;
import com.jfiy.art.entity.User;
import com.jfiy.art.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("ArtworkService")
public class ArtworkServiceImpl implements ArtworkService {
    @Autowired
    ArtworkMapper artworkMapper;
    @Override
    public List<Artwork> getArtworkByUser(User user) {
        System.out.println(user.getName());
        return artworkMapper.findArtworkByUser(user);
    }

    @Override
    public List<Artwork> getArtworkByScore(int offset, int limit) {
        return artworkMapper.findArtworkByScore(new HashMap<String,Integer>(){{
            put("offset",offset);
            put("limit",limit);
        }});
    }

    @Override
    public List<Artwork> getArtworkByTime(int offset, int limit) {
        return artworkMapper.findArtworkByTime(new HashMap<String,Integer>(){{
            put("offset",offset);
            put("limit",limit);
        }});
    }
}
