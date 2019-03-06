package com.hsmy.app.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hsmy.app.BusinessException;
import com.hsmy.app.bean.HsmyInfoPub;
import com.hsmy.app.mapper.HsmyInfoPubMapper;
import com.hsmy.app.service.HsmyInfoService;
import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.utils.WechatUtils;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.LinkedHashMap;
import java.util.List;


// infopub  restful api

@RestController
public class HsmyInfoController {

    private static final Log logger = LogFactory.getLog(HsmyInfoController.class);

    @Resource
    HsmyInfoService hsmyInfoService;

    @Autowired
    HsmyInfoPub hsmyInfoPub;

    @Autowired
    HsmyInfoPubMapper hsmyInfoPubMapper;

    //查询全部信息 注意翻页查询！
    @RequestMapping(path = "/hsmy/infopub", method = RequestMethod.GET)
    public JSONArray selectUnfo() {
        List<LinkedHashMap<String, Object>> infoList = hsmyInfoService.selectInfo();
        JSONArray jsonArray = JSONArray.parseArray(JSONObject.toJSONString(infoList));  /**list为 List<Map<String, String>>**/
        return jsonArray;
    }

    //查询单条信息
    @RequestMapping(path = "/hsmy/infopub/{infoSerno}", method = RequestMethod.GET)
    public Result<HsmyInfoPub> selectInfoPubBySerno(@PathVariable  String infoSerno) {
        hsmyInfoPub = hsmyInfoPubMapper.selectByPrimaryKey(infoSerno);
        if (CommonToolsUtils.isNotNull(hsmyInfoPub)) {
            logger.info(hsmyInfoPub);
            return DefaultResult.newResult(hsmyInfoPub);
        } else {
            logger.info("暂无查询信息");
            return DefaultResult.newFailResult("暂无查询信息.");
        }
    }


    //录入信息
    @RequestMapping(path = "/hsmy/infopub", method = RequestMethod.POST)
    public Result<HsmyInfoPub> insertInfoPub( HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> multipartFiles = mulRequest.getFiles("files");
        String infoPubJson =  mulRequest.getParameter("infopub");
        hsmyInfoPub = (HsmyInfoPub)JSON.parseObject(infoPubJson,HsmyInfoPub.class);
        if (hsmyInfoPub.getOpenId() != null && CommonToolsUtils.isNotNull(hsmyInfoPub)) {
            if(CommonToolsUtils.isNotNull(multipartFiles)){
                MultipartFile multipartFile = null;
                BufferedOutputStream stream = null;
                for (int i = 0; i < multipartFiles.size(); ++i) {
                    multipartFile = multipartFiles.get(i);
                    if (!multipartFile.isEmpty()) {
                        try {
                            //realPath填写电脑文件夹路径
                            String realPath = "D:\\Pictures\\WeChatPic";
                            //格式化时间戳
                            WechatUtils.SaveWechatImage(multipartFile, realPath);
                        } catch (Exception e) {
                            stream = null;
                            return DefaultResult.newFailResult(new BusinessException("发布图片信息异常！"));
                        }
                    }
                }
            }

            //oto do 自定义图片关联存储
            hsmyInfoPub.setPicsDesc("11");
            try {
                int count = hsmyInfoPubMapper.insertSelective(hsmyInfoPub);
                if (count >= 0) {
                    return DefaultResult.newResult(hsmyInfoPub);
                } else {
                    return DefaultResult.newFailResult(new BusinessException("发布信息异常！"));
                }
            } catch (Exception e) {
                logger.info("发布信息异常",e);
                return DefaultResult.newFailResult(new BusinessException("发布信息异常，请重新录入！"));
            }
        } else {
            return DefaultResult.newFailResult(new BusinessException("用户发布信息异常！"));
        }
    }


    //更新信息
    @RequestMapping(path = "/hsmy/infopub", method = RequestMethod.PUT)
    public Result<HsmyInfoPub> updateInfoPub(@RequestBody HsmyInfoPub infoPub) {
        int count  = hsmyInfoPubMapper.updateByPrimaryKey(infoPub);
        if ( CommonToolsUtils.isNotNull(count) && count > 0) {
            logger.info(hsmyInfoPub);
            return DefaultResult.newResult(infoPub);
        } else {
            return DefaultResult.newFailResult("暂无查询信息.");
        }
    }


    //删除信息
    @RequestMapping(path = "/hsmy/infopub", method = RequestMethod.DELETE)
    public Result<Object> deleteInfoPubBySerno(@PathVariable(name = "infoSerno") String infoSerno) {
        int count  = hsmyInfoPubMapper.deleteByPrimaryKey(infoSerno);
        if ( CommonToolsUtils.isNotNull(count) && count > 0) {
            return DefaultResult.newResult("删除成功");
        } else {
            return DefaultResult.newFailResult("暂无查询信息.");
        }
    }






}
