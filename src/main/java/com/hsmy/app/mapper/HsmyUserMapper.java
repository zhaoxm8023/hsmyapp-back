package com.hsmy.app.mapper;

import com.hsmy.app.bean.HsmyUser;
import com.hsmy.app.bean.HsmyUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface HsmyUserMapper {
    long countByExample(HsmyUserExample example);

    int deleteByExample(HsmyUserExample example);

    int deleteByPrimaryKey(String openId);

    int insert(HsmyUser record);

    int insertSelective(HsmyUser record);

    List<HsmyUser> selectByExample(HsmyUserExample example);

    HsmyUser selectByPrimaryKey(String openId);

    int updateByExampleSelective(@Param("record") HsmyUser record, @Param("example") HsmyUserExample example);

    int updateByExample(@Param("record") HsmyUser record, @Param("example") HsmyUserExample example);

    int updateByPrimaryKeySelective(HsmyUser record);

    int updateByPrimaryKey(HsmyUser record);
}