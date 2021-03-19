package com.lml.util;


import com.alibaba.fastjson.JSON;
import com.lml.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class RequestUtil {
    @Autowired
    private HttpServletRequest request;


    @Autowired
    private HttpServletResponse response;




    public Object getForRequest(String name){
        Object attribute = this.getForRequestInAttribute(name);
        if(Objects.isNull(attribute)){
            attribute = this.getForRequestInHeader(name);
        }
        return attribute;
    }

    public String getForRequestInHeader(String name){
        return request.getHeader(name);
    }

    public Object getForRequestInAttribute(String name){
        return request.getAttribute(name);
    }

    public void putSomeThingItoAttribute(String key,Object object){
        request.setAttribute(key,object);
    }

    public User getUserInfo(){
        try {
            return JSON.parseObject(request.getHeader("user"))
                    .toJavaObject(User.class);
        }catch (Exception e){
            return new User();
        }

    }

    public void putErrorResponse(int state,String msg) throws IOException {
        response.sendError(state,msg);
    }

}
