package com.hsmy.app.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hsmy.app.bean.HsmyUser;
import com.hsmy.app.service.HsmyInfoService;
import com.hsmy.app.service.impl.HsmyInfoServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HsmyInfoController {

    private static final Log logger = LogFactory.getLog(HsmyInfoController.class);

    @Resource
    HsmyInfoService hsmyInfoService;


    @RequestMapping(value = "/hsmy/info/qry")
    public JSONArray selectUnfo() {
        List<LinkedHashMap<String, Object>> infoList = hsmyInfoService.selectInfo();
        JSONArray jsonArray = JSONArray.parseArray(JSONObject.toJSONString(infoList));  /**list为 List<Map<String, String>>**/
        return jsonArray;
    }


}
