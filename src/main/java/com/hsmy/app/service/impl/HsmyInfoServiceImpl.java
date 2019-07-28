package com.hsmy.app.service.impl;

import com.hsmy.app.bean.HsmyInfoPub;
import com.hsmy.app.mapper.HsmyInfoPubMapper;
import com.hsmy.app.service.HsmyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class HsmyInfoServiceImpl implements HsmyInfoService {

    @Autowired
    private HsmyInfoPubMapper hsmyInfoPubMapper;


    @Override
    public List<LinkedHashMap<String, Object>> selectInfo(String openId, Integer page, Integer limit) {
        List<LinkedHashMap<String, Object>> infoMapList = null;
        if(openId.equals("all")){
            //openId为all代表查询所有
            infoMapList = hsmyInfoPubMapper.selectInfo();
        }
        else {
            //按openId查询
            infoMapList = hsmyInfoPubMapper.selectInfoByOpenId(openId);
        }
        return infoMapList;
    }
}
