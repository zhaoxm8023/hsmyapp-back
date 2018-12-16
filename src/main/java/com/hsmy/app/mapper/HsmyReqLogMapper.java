package com.hsmy.app.mapper;

import com.hsmy.app.bean.HsmyReqLog;
import com.hsmy.app.bean.HsmyReqLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface HsmyReqLogMapper {
    long countByExample(HsmyReqLogExample example);

    int deleteByExample(HsmyReqLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HsmyReqLog record);

    int insertSelective(HsmyReqLog record);

    List<HsmyReqLog> selectByExample(HsmyReqLogExample example);

    HsmyReqLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HsmyReqLog record, @Param("example") HsmyReqLogExample example);

    int updateByExample(@Param("record") HsmyReqLog record, @Param("example") HsmyReqLogExample example);

    int updateByPrimaryKeySelective(HsmyReqLog record);

    int updateByPrimaryKey(HsmyReqLog record);
}