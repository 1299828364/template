package com.lml.service;

import com.lml.model.User;

public interface UserService {
    String test();

    User getUserByUid(Long uid);


    User getUserByUserName(String userName);
}
