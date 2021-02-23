package com.lml.controller;

import com.lml.model.User;
import com.lml.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EditController
 * @Description
 * @Author lml
 * @Date2021/2/23 16:29
 * @Version V1.0
 **/

@RestController
public class EditController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public User register(@RequestBody User user){
        return userService.addUser(user);
    }
}
