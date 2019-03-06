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
        //��ʽ��ʱ���
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String nowTime = sdf.format(new Date().getTime());

        //�ü��û�id
        String originalFirstName = multipartFile.getOriginalFilename();
        String picFirstName = originalFirstName.substring(0, originalFirstName.indexOf("."));

        //ȡ��ͼƬ�ĸ�ʽ��׺
        String originalLastName = multipartFile.getOriginalFilename();
        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));

        //ƴ�ӣ�����+ʱ���+��׺  �����Զ���
        String picName = picFirstName + "." + nowTime + picLastName;
        try {
            File dir = new File(realPath);
            //����ļ�Ŀ¼�����ڣ������ļ�Ŀ¼
            if (!dir.exists()) {
                dir.mkdir();
                System.out.println("�����ļ�Ŀ¼�ɹ���" + realPath);
            }
            File file = new File(realPath, picName);
            multipartFile.transferTo(file);
            System.out.println("���ͼƬ�ɹ���");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
