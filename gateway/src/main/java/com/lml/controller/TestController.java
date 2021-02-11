package com.lml.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
public class TestController {



    @RequestMapping(value = "/test/{test}")
    public Map<String,String> test(@PathVariable("test")String test){
        Map<String,String> result = new HashMap<>();
        result.put("result",test);
        return result;
    }
}
