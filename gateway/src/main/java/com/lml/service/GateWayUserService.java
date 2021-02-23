package com.lml.service;


import com.lml.model.User;
import com.lml.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "lml-user")
public interface GateWayUserService {
    @RequestMapping(value = "/test2")
    public Result<String> test1();

    //    @Override
    @RequestMapping(value = "/UserById",method = RequestMethod.GET)
    public User getUserByUid(@RequestParam Long uid);

    //    @Override
    @RequestMapping(value = "/UserByName",method = RequestMethod.GET)
    public User getUserByUserName(@RequestParam String userName);

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public User register(User user);
}
