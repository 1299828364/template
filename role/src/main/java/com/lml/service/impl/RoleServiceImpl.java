package com.lml.service.impl;

import com.lml.dao.RoleDao;
import com.lml.model.Role;
import com.lml.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll(){
        return roleDao.findAll();
    }
}
