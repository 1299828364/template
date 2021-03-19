package com.lml.service;

import com.lml.model.User;
import com.lml.model.request.UserQueryRequest;

import java.util.List;

public interface UserService {
    String test();

    List<User> listUser(UserQueryRequest request);

    User getUserByUid(Long uid);


    User getUserByUserName(String userName);

    User addUser(User user);
}
