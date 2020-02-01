package com.hsmy.app.web;


import com.hsmy.app.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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


    @Value( "${spring.apollo.teststr2}" )
    String port;

    @GetMapping("hi")
    @ResponseBody
    public String hi(String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

}
