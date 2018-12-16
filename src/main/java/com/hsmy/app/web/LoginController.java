package com.hsmy.app.web;


import com.hsmy.app.BusinessException;
import com.hsmy.app.bean.HsmyUser;
import com.hsmy.app.mapper.HsmyUserMapper;
import com.hsmy.app.service.WebTokenService;
import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
        logger.info( "---我去 : "  + hsmyUser.getOpenId());
        return "1";
    }


    // 根据团队 id 及 微信 openId 查询绑定的用户
    @RequestMapping(path = "/hsmy/user/{openId}", method = RequestMethod.GET)
    public Result<HsmyUser> getUser(@PathVariable(name = "openId") String openId) {
        // find by openid
        hsmyUser = hsmyUserMapper.selectByPrimaryKey(openId);
        Assert.notNull(hsmyUser, "用户不存在.");
        if (CommonToolsUtils.isNotNull(hsmyUser)) {
            String token = webTokenService.generate(hsmyUser.getOpenId());
            return DefaultResult.newResult(hsmyUser).setHeader("token", token);
        } else {
            return DefaultResult.newFailResult("用户暂未绑定.");
        }
    }



    // 加入小区
    @RequestMapping(path = "/hsmy/usr/join", method = RequestMethod.POST)
    public Result<HsmyUser> join(@PathVariable Long id, @RequestBody HsmyUser user,
                                 @RequestParam(name = "token") String token) {
//        Team team = teamRepository.findOne(id);
//        Assert.notNull(team, "团队不存在.");
//        Assert.isTrue(team.getToken().equals(token), "口令校验失败.");
        if (user.getOpenId() != null  &&  CommonToolsUtils.isNotNull(user)) {
            try{
                int count = hsmyUserMapper.insertSelective(user);
                if (count >= 0 ){
                    return DefaultResult.newResult(user).setHeader("token", webTokenService.generate(user.getOpenId()));
                }
                else{
                    throw new BusinessException("用户注册异常！");
                }
            }catch (Exception e) {
                throw new BusinessException("用户注册异常！");
            }
        }
        else{
            throw new BusinessException("用户注册异常！");
            //throw new RuntimeException("不可重复加入小区.");
        }
    }

}
