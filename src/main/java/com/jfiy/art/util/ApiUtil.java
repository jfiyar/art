package com.jfiy.art.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class ApiUtil {

    public static String RestJson(Object data){
        Map<String, Object> map=new HashMap<>();
        map.put("success",true);
        map.put("data",data);
        return JSON.toJSONString(map);
    }
    public static String RestJson(Object data,String message){
        Map<String, Object> map=new HashMap<>();
        map.put("success",false);
        map.put("message",message);
        map.put("data",data);
        return JSON.toJSONString(map);
    }
}
