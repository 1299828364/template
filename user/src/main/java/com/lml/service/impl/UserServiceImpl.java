package com.lml.service.impl;

import com.lml.dao.UserQueryDao;
import com.lml.model.User;
import com.lml.model.request.UserQueryRequest;
import com.lml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserQueryDao userQueryDao;

    @Override
    public String test(){
        return "User's test";
    }

    @Override
    public List<User> listUser(UserQueryRequest request) {
        Specification<User> arg = request.getWhereCriteria();
        Page<User> users = userQueryDao.findAll(arg,request.getPageRequest());
        
        return null;
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
