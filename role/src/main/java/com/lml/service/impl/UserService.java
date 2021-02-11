package com.lml.service.impl;


import com.lml.config.FeignHeaderConfig;
import com.lml.model.Role;
import com.lml.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "lml-user",contextId = "role-lml-user",configuration = FeignHeaderConfig.class)
public interface UserService{
    @RequestMapping(value = "/test2")
    public Result<String> test1();
}
