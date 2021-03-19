package com.lml.dao;

import com.lml.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//实现JpaSpecificationExecutor以提供对jpa高级筛选的支持
public interface UserQueryDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    User findByUserName(String userName);
}
