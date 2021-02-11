package com.lml.provider;


import com.lml.model.Role;
import com.lml.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


public interface RoleProvider {

    @RequestMapping(value = "/findAll")
    Result<List<Role>> findAll();
}
