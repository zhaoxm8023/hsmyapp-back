package com.hsmy.app.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WechatUtils {

    private static final Log logger = LogFactory.getLog(WechatUtils.class);
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


    public static String SaveWechatImage(MultipartFile multipartFile, String realPath, String fileSerno) {
        //格式化时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String nowTime = sdf.format(new Date().getTime());

        //取得图片前缀名称
        String originalFirstName = multipartFile.getOriginalFilename();
        String picFirstName = originalFirstName.substring(0, originalFirstName.indexOf("."));

        //取得图片的格式后缀
        String originalLastName = multipartFile.getOriginalFilename();
        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));

        //拼接：名字+时间戳+后缀  可以自定义
        String picName = fileSerno + picFirstName + "." + nowTime + picLastName;
        try {
            //默认目录 + 微信id作为图片查询目录
            File dir = new File(realPath);
            //如果文件目录不存在，创建文件目录
            if (!dir.exists()) {
                dir.mkdir();
                logger.info("创建文件目录成功：" + realPath);
            }
            File file = new File(realPath, picName);
            multipartFile.transferTo(file);
            logger.info("添加图片成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return picName ;
    }
}
