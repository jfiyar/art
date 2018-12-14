package com.jfiy.art.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello,Spring Boot";
    }
}