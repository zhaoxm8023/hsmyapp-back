package com.hsmy.app.service;

import com.hsmy.app.bean.HsmyInfoPub;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public interface HsmyInfoService {
    public List<LinkedHashMap<String, Object>> selectInfo();
}
