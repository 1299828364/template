package com.lml.controller;

import com.lml.model.User;
import com.lml.result.Result;
//import com.lml.util.RequestUtil;
import com.lml.util.RequestUtil;
import com.lml.util.ResultUtil;
import com.lml.service.UserService;
//import com.lml.util.Test;
import com.lml.util.RoleTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class QueryController /*implements UserQueryProvider*/ {

//    @Autowired
//    RoleProvider roleProvider;

//    @RequestMapping(value = "/test1")
//    public Result<List<Role>> test1(){
//        return roleProvider.findAll();
//    }

    @Autowired
    UserService userService;

    @Autowired
    RequestUtil requestUtil;


    @RequestMapping(value = "/test2")
    @RoleTest(hasRole = "游客会员")
    public Result<String> test1(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(requestUtil.getUserInfo());
        return ResultUtil.success("user.queryController.test2");
    }

//    @Override
    @RequestMapping(value = "/UserById",method = RequestMethod.GET)
    public User getUserByUid(@RequestParam Long uid) {
        return userService.getUserByUid(uid);
    }

//    @Override
    @RequestMapping(value = "UserByName",method = RequestMethod.GET)
    public User getUserByUserName(@RequestParam String userName){
        return userService.getUserByUserName(userName);
    }
}
