package com.lml.dao;


import com.lml.model.Role;
import com.lml.result.Result;
import com.lml.service.RoleService;
import com.lml.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll")
    public Result<List<Role>> findAll(){
        return ResultUtil.success(roleService.findAll());
    }
}
