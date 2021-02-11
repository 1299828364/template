package com.lml.dao;

import com.lml.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQueryDao extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
