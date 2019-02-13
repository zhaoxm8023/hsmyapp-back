package com.hsmy.app.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class WechatUtils {

//    public static String[] ignoreUriPatterns;
//
//    public static PathMatcher pathMatcher = new AntPathMatcher();
//
//
//    public static boolean isIgnoreUri(String uri) {
//        if (null == ignoreUriPatterns)
//            return false;
//        return Arrays.asList(ignoreUriPatterns).stream().anyMatch(p -> pathMatcher.match(p, uri));
//    }
//
//    @Value("${web.token.ignore.uri.pattern}")
//    public static  void setIgnoreUripattern(String ignoreUripattern) {
//        if (!org.springframework.util.StringUtils.isEmpty(ignoreUripattern))
//            ignoreUriPatterns = StringUtils.tokenizeToStringArray(ignoreUripattern, ",");
//    }
}
