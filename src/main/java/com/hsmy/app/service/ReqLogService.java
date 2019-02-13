package com.hsmy.app.service;

import com.hsmy.app.bean.HsmyReqLog;

public interface ReqLogService {
    /**
     * 保存请求日志
     *
     * @param reqLog
     */
    void save(HsmyReqLog reqLog);

}
