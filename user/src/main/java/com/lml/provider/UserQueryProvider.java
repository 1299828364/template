package com.lml.provider;

import com.lml.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public interface UserQueryProvider {

    @RequestMapping("/user/{id}")
    public User getUserByUid(@PathVariable("id") Long uid);

    @RequestMapping("/user/{useName}")
    public User getUserByUserName(@PathVariable("useName")String userName);
}
