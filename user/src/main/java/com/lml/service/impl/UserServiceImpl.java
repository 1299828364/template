package com.lml.service.impl;

import com.lml.dao.UserQueryDao;
import com.lml.model.User;
import com.lml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserQueryDao userQueryDao;

    @Override
    public String test(){
        return "User's test";
    }

    @Override
    public User getUserByUid(Long uid){
        return userQueryDao.findById(uid).orElse(null);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userQueryDao.findByUserName(userName);
    }

    @Override
    public User addUser(User user) {
        userQueryDao.save(user);
        return user;
    }
}
