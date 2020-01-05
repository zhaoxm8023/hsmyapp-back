package com.hsmy.app.service.impl;

import java.security.Key;

import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.hsmy.app.service.WebTokenService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * 使用 JJWT 做为 WebToken 的实现，当前的实现每次服务启动都生成一个新的 key，且不支持集群环境下使用，后续考虑配置文件或者数据库的方式.
 *
 * @author devzzm
 */
@Component
public class SimpleJJWTWebTokenServiceImpl implements WebTokenService {

    private static final Log logger = LogFactory.getLog(SimpleJJWTWebTokenServiceImpl.class);

    private Key key = MacProvider.generateKey();

    @Override
    public String generate(String subject) {
        if(CommonToolsUtils.isNull(subject) || StringUtils.isEmpty(subject)){
            return "";
        }
        return Jwts.builder().setSubject(subject).signWith(SignatureAlgorithm.HS512, key).compact();
    }

    @Override
    public boolean verify(String subject, String token) {
        try {
            //验证时间和相关信息的解析
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject().equals(subject);
        } catch (Exception e) {
            logger.error("Verify fail:", e);
            return false;
        }
    }
}
