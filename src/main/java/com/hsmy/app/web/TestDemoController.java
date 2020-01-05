package com.hsmy.app.web;


import com.hsmy.app.utils.RedisUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestDemoController {

    @Resource
    private RedisUtils redisUtils;


    @RequestMapping(value = "/get/{key}")
    public Object redisget(@PathVariable String key){
        return redisUtils.get(key);
    }

    @RequestMapping(value = "/set/{key}")
    public Object redisset(@PathVariable String key){
        return redisUtils.set(key,key);
    }


}
