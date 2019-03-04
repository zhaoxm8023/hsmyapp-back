package com.hsmy.app.web;


import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.hsmy.app.BusinessException;
import com.hsmy.app.bean.ApiResponse;
import com.hsmy.app.bean.HsmyUser;
import com.hsmy.app.mapper.HsmyUserMapper;
import com.hsmy.app.service.WebTokenService;
import com.hsmy.app.utils.AliyunMessageUtil;
import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.utils.EbaseYunMessageUtil;
import com.hsmy.app.utils.StringUtils;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private static final Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    HsmyUser hsmyUser;

    @Autowired
    HsmyUserMapper hsmyUserMapper;

    @Autowired
    private WebTokenService webTokenService;


    @RequestMapping(value = "/qryhsmyuser")
    public String selectUsers() {
        //openid
        String openId = "1";
        hsmyUser = hsmyUserMapper.selectByPrimaryKey(openId);
        logger.info("---我去 : " + hsmyUser.getOpenId());
        return "1";
    }


    // 根据团队 id 及 微信 openId 查询绑定的用户
    @RequestMapping(path = "/hsmy/user/{openId}", method = RequestMethod.GET)
    public Result<HsmyUser> getUser(@PathVariable(name = "openId") String openId) {
        // find by openid
        hsmyUser = hsmyUserMapper.selectByPrimaryKey(openId);
        //Assert.notNull(hsmyUser, "用户不存在.");
        if (CommonToolsUtils.isNotNull(hsmyUser)) {
            logger.info(hsmyUser);
            String token = webTokenService.generate(hsmyUser.getOpenId());
            return DefaultResult.newResult(hsmyUser).setHeader("token", token);
        } else {
            logger.info("用户暂未绑定");
            return DefaultResult.newFailResult("用户暂未绑定.");
        }

    }


    // 加入小区
    @RequestMapping(path = "/hsmy/user/join", method = RequestMethod.POST)
    public Result<HsmyUser> join(@RequestBody HsmyUser user) {
//        Team team = teamRepository.findOne(id);
//        Assert.notNull(team, "团队不存在.");
//        Assert.isTrue(team.getToken().equals(token), "口令校验失败.");
        if (user.getOpenId() != null && CommonToolsUtils.isNotNull(user)) {
            try {
                int count = hsmyUserMapper.insertSelective(user);
                if (count >= 0) {
                    return DefaultResult.newResult(user).setHeader("token", webTokenService.generate(user.getOpenId()));
                } else {
                    return DefaultResult.newFailResult(new BusinessException("用户注册异常！"));
                }
            } catch (Exception e) {
                logger.info("登录异常",e);
                return DefaultResult.newFailResult(new BusinessException("不可重复加入小区！"));
            }
        } else {
            return DefaultResult.newFailResult(new BusinessException("用户注册异常！"));
        }
    }


    @RequestMapping(path = "/hsmy/sms/{phoneno}", method = RequestMethod.GET)
    public Result<String> sendMsg(@PathVariable(name = "phoneno") String phoneno) throws ClientException {
        //验证码
        String code = "";
        try {
            ApiResponse apiResponse = EbaseYunMessageUtil.sendMsg(phoneno); //网易云短信
            if (StringUtils.isNotEmpty(apiResponse.getCode()) && "200".equals(apiResponse.getCode())) {
                code = apiResponse.getCheckNum();
                logger.info("短信验证码为：" + code);
            } else {
                return DefaultResult.newFailResult(new BusinessException("获取短信验证码异常！"));

            }
        } catch (Exception e) {
            return DefaultResult.newFailResult(new BusinessException("获取短信验证码异常！"));
        }
        return DefaultResult.newResult(code).setHeader("token", webTokenService.generate("11"));
    }

    /**
     * 生成随机数
     *
     * @param num 位数
     * @return
     */
    public static String createRandomNum(int num) {
        String randomNumStr = "";
        for (int i = 0; i < num; i++) {
            int randomNum = (int) (Math.random() * 10);
            randomNumStr += randomNum;
        }
        return randomNumStr;
    }


    //        String phoneNumber = phoneno;
//        String randomNum = createRandomNum(6);
//        String jsonContent = "{\"number\":\"" + randomNum + "\"}";
//
//        Map<String, String> paramMap = new HashMap<>();
//        paramMap.put("phoneNumber", phoneNumber);
//        paramMap.put("msgSign", "海上明月");
//        paramMap.put("templateCode", "xxxxxxxx");
//        paramMap.put("jsonContent", jsonContent);
//        SendSmsResponse sendSmsResponse = AliyunMessageUtil.sendSms(paramMap);
//        logger.info(sendSmsResponse.getCode());
//        if(!(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK"))) {
//            if(sendSmsResponse.getCode() == null) {
//                //这里可以抛出自定义异常
//                return   DefaultResult.newFailResult( new BusinessException("获取短信验证码异常！"));
//            }
//            if(!sendSmsResponse.getCode().equals("OK")) {
//                //这里可以抛出自定义异常
//                return   DefaultResult.newFailResult( new BusinessException("获取短信验证码异常！"));
//            }
//        }


}
