package com.hsmy.app.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

    public static void SaveWechatImage(MultipartFile multipartFile, String realPath) {
        //格式化时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String nowTime = sdf.format(new Date().getTime());

        //裁剪用户id
        String originalFirstName = multipartFile.getOriginalFilename();
        String picFirstName = originalFirstName.substring(0, originalFirstName.indexOf("."));

        //取得图片的格式后缀
        String originalLastName = multipartFile.getOriginalFilename();
        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));

        //拼接：名字+时间戳+后缀  可以自定义
        String picName = picFirstName + "." + nowTime + picLastName;
        try {
            File dir = new File(realPath);
            //如果文件目录不存在，创建文件目录
            if (!dir.exists()) {
                dir.mkdir();
                System.out.println("创建文件目录成功：" + realPath);
            }
            File file = new File(realPath, picName);
            multipartFile.transferTo(file);
            System.out.println("添加图片成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
