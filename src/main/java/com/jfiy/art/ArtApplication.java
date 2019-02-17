package com.jfiy.art;

import com.jfiy.art.service.serviceImpl.ArtworkServiceImpl;
import com.jfiy.art.service.serviceImpl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArtApplication.class, args);
    }

}

