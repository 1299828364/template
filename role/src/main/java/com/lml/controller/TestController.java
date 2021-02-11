package com.lml.controller;


import com.lml.result.Result;
import com.lml.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping("/test233")
    public Result<String> test(){
        return userService.test1();
    }
}
