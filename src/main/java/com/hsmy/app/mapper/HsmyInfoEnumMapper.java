package com.hsmy.app.mapper;

import com.hsmy.app.bean.HsmyInfoEnum;
import com.hsmy.app.bean.HsmyInfoEnumExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface HsmyInfoEnumMapper {
    long countByExample(HsmyInfoEnumExample example);

    int deleteByExample(HsmyInfoEnumExample example);

    int deleteByPrimaryKey(String infoenum);

    int insert(HsmyInfoEnum record);

    int insertSelective(HsmyInfoEnum record);

    List<HsmyInfoEnum> selectByExample(HsmyInfoEnumExample example);

    HsmyInfoEnum selectByPrimaryKey(String infoenum);

    int updateByExampleSelective(@Param("record") HsmyInfoEnum record, @Param("example") HsmyInfoEnumExample example);

    int updateByExample(@Param("record") HsmyInfoEnum record, @Param("example") HsmyInfoEnumExample example);

    int updateByPrimaryKeySelective(HsmyInfoEnum record);

    int updateByPrimaryKey(HsmyInfoEnum record);
}