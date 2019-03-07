package com.hsmy.app.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hsmy.app.bean.HsmyInfoPub;
import com.hsmy.app.constant.ConstantErrMsg;
import com.hsmy.app.enums.SequenceNameEnum;
import com.hsmy.app.enums.SequenceNumberEnum;
import com.hsmy.app.mapper.HsmyInfoPubMapper;
import com.hsmy.app.service.HsmyInfoService;
import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.utils.DateUtils;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
        //to do  查找附件的操作

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
    public Result<HsmyInfoPub> insertInfoPub(@RequestBody HsmyInfoPub hsmyInfoPub) {
        try {
            if (hsmyInfoPub.getOpenId() != null && CommonToolsUtils.isNotNull(hsmyInfoPub)) {
                Map<String, Object> param = new HashMap<>();
                param.put("sequencename", SequenceNameEnum.INFOPUBSEQUENCE.value() );
                param.put("sequenceday","d");
                param.put("sequencelenth", SequenceNumberEnum.EIGHTSEQUENCE.value());
                hsmyInfoPub.setInfoSerno(hsmyInfoPubMapper.getAppSequenceNo(param)); // 主键sequence
                hsmyInfoPub.setInfoWorkdata(DateUtils.format(new Date(),"yyyy-MM-dd"));
                hsmyInfoPub.setLastDate(new Date());
                logger.info(hsmyInfoPub);
                //存储图片
                int count = hsmyInfoPubMapper.insertSelective(hsmyInfoPub);
                if (count >= 0) {
                    return DefaultResult.newResult(hsmyInfoPub);
                } else {
                    return DefaultResult.newFailResult( ConstantErrMsg.INFOPUBMSG + ConstantErrMsg.UPDATEFAIL  );
                }
            } else {
                return DefaultResult.newFailResult( ConstantErrMsg.INFOPUBMSG + ConstantErrMsg.UPDATEFAIL  );
            }
        }catch (Exception e){
            return DefaultResult.newFailResult( ConstantErrMsg.INFOPUBMSG + ConstantErrMsg.UPDATEFAIL + ConstantErrMsg.TRYCATCHEXCEPTION);
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
