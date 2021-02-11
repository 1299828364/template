package com.lml.util.dao;

import com.lml.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRole,Integer> {
    List<UserRole> findByUid(Long uid);
}
