package com.jfiy.art.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class ApiUtil {

    public static String RestJson(Map data){
        Map<String, Object> map=new HashMap<>();
        map.put("success",data);
        return JSON.toJSONString(map);
    }
    public static String RestJson(String errorMessage){
        Map<String, Object> map=new HashMap<>();
        map.put("error",errorMessage);
        return JSON.toJSONString(map);
    }
    public static String RestJson(Map data,String errMessage){
        Map<String, Object> map=new HashMap<>();
        map.put("error",errMessage);
        map.put("success",data);
        return JSON.toJSONString(map);
    }

}
