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
    public List<LinkedHashMap<String, Object>> selectInfo() {
        return hsmyInfoPubMapper.selectInfo();
    }
}