package com.hsmy.app.mapper;

import com.hsmy.app.bean.HsmyInfoPub;
import com.hsmy.app.bean.HsmyInfoPubExample;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface HsmyInfoPubMapper {
    long countByExample(HsmyInfoPubExample example);

    int deleteByExample(HsmyInfoPubExample example);

    int deleteByPrimaryKey(String infoSerno);

    int insert(HsmyInfoPub record);

    int insertSelective(HsmyInfoPub record);

    List<HsmyInfoPub> selectByExample(HsmyInfoPubExample example);

    HsmyInfoPub selectByPrimaryKey(String infoSerno);

    int updateByExampleSelective(@Param("record") HsmyInfoPub record, @Param("example") HsmyInfoPubExample example);

    int updateByExample(@Param("record") HsmyInfoPub record, @Param("example") HsmyInfoPubExample example);

    int updateByPrimaryKeySelective(HsmyInfoPub record);

    int updateByPrimaryKey(HsmyInfoPub record);

    List<LinkedHashMap<String, Object>> selectInfo();

    String getAppSequenceNo(Map<String, Object> params);
}