package com.hsmy.app.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsmy.app.BusinessException;
import com.hsmy.app.bean.HsmyInfoPub;
import com.hsmy.app.enums.SequenceNameEnum;
import com.hsmy.app.enums.SequenceNumberEnum;
import com.hsmy.app.mapper.HsmyInfoPubMapper;
import com.hsmy.app.service.HsmyInfoService;
import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.utils.DateUtils;
import com.hsmy.app.utils.WechatUtils;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.*;


@RestController
public class HsmyInfoController {

    private static final Log logger = LogFactory.getLog(HsmyInfoController.class);

    @Resource
    HsmyInfoService hsmyInfoService;

    @Autowired
    HsmyInfoPub hsmyInfoPub;

    @Autowired
    HsmyInfoPubMapper hsmyInfoPubMapper;

    @Value("${wechat.infopub.filepath}")
    String infopubFilesPath;

    @Value("${wechat.infopub.filesplitchar}")
    String splitchar;

    //查询全部信息 注意翻页查询！
    @ApiOperation(value = "查询发布信息")
    @RequestMapping(path = "/hsmy/infopub/list/{openId}/{page}/{limit}", method = RequestMethod.GET)
    public JSONObject selectUnfo(@PathVariable("openId") String openId,@PathVariable("page") Integer page,@PathVariable("limit") Integer limit) {
        JSONObject map = new JSONObject();//创建JSONmap来存放JSON数据传到前台
        PageHelper.startPage(page , limit);//设置数据库分页查询的范围
        List<LinkedHashMap<String, Object>> infoList = hsmyInfoService.selectInfo(openId,page,limit);
        PageInfo<LinkedHashMap<String, Object>> pageInfo = new PageInfo<>(infoList);
        map.put("count",pageInfo.getTotal());//获取查询总条数
        map.put("data",infoList);

        JSONObject jsonArray = JSONArray.parseObject(JSONObject.toJSONString(map));
        logger.info(jsonArray);
        return jsonArray;
    }

    //查询单条信息
    @RequestMapping(path = "/hsmy/infopub/{infoSerno}", method = RequestMethod.GET)
    public Result<HsmyInfoPub> selectInfoPubBySerno(@PathVariable  String infoSerno) {
        hsmyInfoPub = hsmyInfoPubMapper.selectByPrimaryKey(infoSerno);
        //to do  查找附件的操作

        if (CommonToolsUtils.isNotNull(hsmyInfoPub)) {
            logger.info(hsmyInfoPub);
            return DefaultResult.newResult(hsmyInfoPub);
        } else {
            logger.info("暂无查询信息");
            return DefaultResult.newFailResult("暂无查询信息.");
        }
    }


    //录入单文本信息
    @RequestMapping(path = "/hsmy/infopub/wordsonly", method = RequestMethod.POST)
    public Result<HsmyInfoPub> insertInfoPubWordsOnly(@RequestBody HsmyInfoPub hsmyInfoPub){
        if (hsmyInfoPub.getOpenId() != null && CommonToolsUtils.isNotNull(hsmyInfoPub)){
            logger.info("Openid:" + hsmyInfoPub.getOpenId());
            Map<String, Object> param = new HashMap<>();
            param.put("sequencename", SequenceNameEnum.INFOPUBSEQUENCE.value());
            param.put("sequenceday", "d");
            param.put("sequencelenth", SequenceNumberEnum.EIGHTSEQUENCE.value());
            hsmyInfoPub.setInfoSerno(hsmyInfoPubMapper.getAppSequenceNo(param)); // 主键sequence
            hsmyInfoPub.setLastDate(new Date());
            hsmyInfoPub.setInfoWorkdata(DateUtils.format(new Date(),"yyyy-MM-dd"));
            //图片关联存储路径及名称记表 跟 infoSerno关联 为空代表无图片
            hsmyInfoPub.setPicsDesc("");
            logger.info(hsmyInfoPub);
            //存储图片
            int count = hsmyInfoPubMapper.insertSelective(hsmyInfoPub);
        }
        return DefaultResult.newResult(hsmyInfoPub);
    }


    //录入信息
    @RequestMapping(path = "/hsmy/infopub", method = RequestMethod.POST)
    public Result<HsmyInfoPub> insertInfoPub(HttpServletRequest request, HttpServletResponse response) {
        try {
            MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> multipartFiles = mulRequest.getFiles("infopubfiles");
            String openId = mulRequest.getHeader("openId");
            String picsSerno = mulRequest.getParameter("picsSerno");
            String maxCount = mulRequest.getParameter("maxCount");
            String curIndex = mulRequest.getParameter("curIndex");
            if (CommonToolsUtils.isNotNull(openId) && CommonToolsUtils.isNotNull(picsSerno)) {
                String picsDesc = infopubFilesPath + "\\Default.png";  //加一张默认一张图片
                //处理附件程序
                if (CommonToolsUtils.isNotNull(multipartFiles)) {
                    picsDesc = "";
                    MultipartFile multipartFile = null;
                    BufferedOutputStream stream = null;
                    for (int i = 0; i < multipartFiles.size(); ++i) {
                        multipartFile = multipartFiles.get(i);
                        if (!multipartFile.isEmpty()) {
                            try {
                                picsDesc += WechatUtils.SaveWechatImage(multipartFile, infopubFilesPath + File.separator + openId, picsSerno) + splitchar;
                            } catch (Exception e) {
                                stream = null;
                                return DefaultResult.newFailResult(new BusinessException("提交发布图片信息异常！"));
                            }
                        }
                    }
                }

                //图片上传完毕 插入表单信息
                if (curIndex.equals( maxCount)) {
                    String infoPubJson = mulRequest.getParameter("dataInfo");
                    logger.info("infoPubJson" + infoPubJson);
                    hsmyInfoPub = (HsmyInfoPub) JSON.parseObject(infoPubJson, HsmyInfoPub.class);
                    Map<String, Object> param = new HashMap<>();
                    param.put("sequencename", SequenceNameEnum.INFOPUBSEQUENCE.value());
                    param.put("sequenceday", "d");
                    param.put("sequencelenth", SequenceNumberEnum.EIGHTSEQUENCE.value());
                    hsmyInfoPub.setInfoSerno(hsmyInfoPubMapper.getAppSequenceNo(param)); // 主键sequence
                    hsmyInfoPub.setLastDate(new Date());
                    hsmyInfoPub.setInfoWorkdata(DateUtils.format(new Date(),"yyyy-MM-dd"));
                    //图片关联存储路径及名称记表 跟 infoSerno关联
                    hsmyInfoPub.setPicsDesc(picsSerno);
                    logger.info(hsmyInfoPub);
                    //存储图片
                    int count = hsmyInfoPubMapper.insertSelective(hsmyInfoPub);
                    if (count >= 0) {
                        return DefaultResult.newResult(hsmyInfoPub);
                    } else {
                        return DefaultResult.newFailResult(new BusinessException("发布信息异常！"));
                    }
                } else{
                    return DefaultResult.newResult(hsmyInfoPub);
                }
            } else {
                return DefaultResult.newFailResult(new BusinessException("用户发布信息异常！"));
            }
        } catch (Exception e) {
            return DefaultResult.newFailResult(new BusinessException("提交错误，发布信息异常！"));
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
