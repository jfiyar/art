package com.jfiy.art.util;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

@ControllerAdvice
public class ResultFormatter implements ResponseBodyAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String[] handleException(Exception e){
        e.printStackTrace();
        return new String[]{"err", e.toString()};
    }
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        HashMap<String, Object> map=new HashMap<>();
        if(o instanceof String[]){
            String[] e=(String[]) o;
            if(e[0].equals("err")&&e.length==2){
                map.put("code",500);
                map.put("message",e[1]);
            }else {
                map.put("code",200);
                map.put("data",o);
            }
        }else {
            map.put("code",200);
            map.put("data",o);
        }
        return map;
    }
}
