package com.hsmy.app.service.impl;

import com.hsmy.app.bean.HsmyReqLog;
import com.hsmy.app.mapper.HsmyReqLogMapper;
import com.hsmy.app.service.ReqLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description :
 */
@Service
public class ReqLogServiceImpl implements ReqLogService {

    @Autowired
    private HsmyReqLogMapper hsmyReqLogMapper;

    @Override
    public void save(HsmyReqLog hsmyReqLog) {
        hsmyReqLogMapper.insertSelective(hsmyReqLog);
    }

}
