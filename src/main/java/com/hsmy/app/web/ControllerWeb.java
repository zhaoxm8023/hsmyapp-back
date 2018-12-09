package com.hsmy.app.web;


import com.hsmy.app.bean.User;
import com.hsmy.app.mapper.UserMapper;
import com.hsmy.app.service.impl.SimpleJJWTWebTokenServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ControllerWeb {
    private static final Log logger = LogFactory.getLog(ControllerWeb.class);

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/user")
    public Object payOrder() {
        User user = new User();
        user.setId(20);
        return  userMapper.insertSelective(user);
    }


    @RequestMapping(value = "/qryuser")
    public String selectUsers() {
        ArrayList<User>  aUsers  = userMapper.selectall();
        logger.info( "---我去 : "  + aUsers.get(0).getId());
        return "1";
        //return  userMapper.insertSelective(user);
    }




}
