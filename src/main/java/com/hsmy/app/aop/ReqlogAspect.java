package com.hsmy.app.aop;


import com.hsmy.app.annotation.ReqLogger;
import com.hsmy.app.bean.HsmyReqLog;
import com.hsmy.app.service.ReqLogService;
import com.hsmy.app.service.WebTokenService;
import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.utils.JsonUtils;
import com.hsmy.app.utils.WebUtils;
import com.hsmy.app.utils.WechatUtils;
import org.apache.catalina.session.StandardSessionFacade;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class ReqlogAspect {
    private final static Logger logger = LoggerFactory.getLogger(ReqlogAspect.class);

    @Autowired
    private HsmyReqLog hsmyReqLog;

    @Resource
    private ReqLogService reqLogService;


    private String[] ignoreUriPatterns;

    private PathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    private WebTokenService webTokenService;

    private String tokenKey = "Authorization";

    private String subjectKey = "Subject";


    @Pointcut("execution(public * com.hsmy.app.web.*Controller.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void saveReqLog(JoinPoint joinPoint) {
        logger.info("--------   hsmy aop  saveReqLog  --------");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取request
        HttpServletRequest request = WebUtils.getHttpServletRequest();

        //注解上的描述
        ReqLogger reqlog = signature.getMethod().getAnnotation(ReqLogger.class);

        //请求的方法名
        hsmyReqLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName() + "()");

        //请求的参数
        StringBuilder params = new StringBuilder();
        Object[] parameter = joinPoint.getArgs();
        String[] paramNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < parameter.length; i++) {
            if (!(parameter[i] instanceof ServletRequest) && !(parameter[i] instanceof StandardSessionFacade)) {
                String parm = JsonUtils.toJSONString(parameter[i]);
                params.append(paramNames[i]).append(":").append(parm).append(";");
            }
        }
        hsmyReqLog.setParams(params.toString());

        //设置IP地址
        hsmyReqLog.setClientIp(WebUtils.getIpAddr(request));

        //日志时间
        hsmyReqLog.setCreateTime(new Date());

        //用户openid  / token
        //if (isIgnoreUri(request.getRequestURI()) && CommonToolsUtils.isNull(request.getHeader(tokenKey))) {
        hsmyReqLog.setTokenId("default");
        //} else {
        //  hsmyReqLog.setTokenId(request.getHeader(tokenKey));
        //}

        logger.info("hsmyReqlogger ={}", "[" + request.getRequestURL().toString() + "]" + JsonUtils.toJSONString(hsmyReqLog));
        //保存系统日志
        reqLogService.save(hsmyReqLog);
    }
//
//    private boolean isIgnoreUri(String uri) {
//        if (null == ignoreUriPatterns)
//            return false;
//        return Arrays.asList(ignoreUriPatterns).stream().anyMatch(p -> pathMatcher.match(p, uri));
//    }
//
//
//    @Value("${web.token.ignore.uri.pattern}")
//    public void setIgnoreUripattern(String ignoreUripattern) {
//        if (!StringUtils.isEmpty(ignoreUripattern))
//            ignoreUriPatterns = StringUtils.tokenizeToStringArray(ignoreUripattern, ",");
//    }

}