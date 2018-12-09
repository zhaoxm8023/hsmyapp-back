package com.hsmy.app.mapper;

import com.hsmy.app.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    ArrayList<User> selectall();
}