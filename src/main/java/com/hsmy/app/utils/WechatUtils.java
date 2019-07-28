package com.hsmy.app.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WechatUtils {

    private static final Log logger = LogFactory.getLog(WechatUtils.class);

    public static String SaveWechatImage(MultipartFile multipartFile, String realPath ) {
        //��ʽ��ʱ���
        String nowTime = DateUtils.format(new Date(),"yyyy-MM-dd-HH-mm-ss");

        //ȡ��ͼƬǰ׺����
        String originalFirstName = multipartFile.getOriginalFilename();
        String picFirstName = originalFirstName.substring(0, originalFirstName.indexOf("."));

        //ȡ��ͼƬ�ĸ�ʽ��׺
        String originalLastName = multipartFile.getOriginalFilename();
        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));

        //ƴ�ӣ�����+ʱ���+��׺  �����Զ���
        String picName = picFirstName + "." + nowTime + picLastName;
        saveImage(multipartFile, realPath, picName);
        return picName ;
    }

    public  static ArrayList<String> getWebchatImage(String fileDesc, String filePath){
        return  FileUtils.getFileListame(filePath , fileDesc);
    }

    public static String SaveWechatImage(MultipartFile multipartFile, String realPath, String fileSerno) {
        //��ʽ��ʱ���
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-S");
        String nowTime = sdf.format(new Date().getTime());

        //ȡ��ͼƬǰ׺����
        String originalFirstName = multipartFile.getOriginalFilename();
        String picFirstName = originalFirstName.substring(0, originalFirstName.indexOf("."));

        //ȡ��ͼƬ�ĸ�ʽ��׺
        String originalLastName = multipartFile.getOriginalFilename();
        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));

        //ƴ�ӣ�����+ʱ���+��׺  �����Զ���
        String picName = fileSerno + picFirstName + "." + nowTime + picLastName;
        logger.info("ͼƬ����Ϊ��" + picName);
        saveImage(multipartFile, realPath, picName);
        return picName ;
    }

    private static void saveImage(MultipartFile multipartFile, String realPath, String picName) {
        try {
            //Ĭ��Ŀ¼ + ΢��id��ΪͼƬ��ѯĿ¼
            File dir = new File(realPath);
            //����ļ�Ŀ¼�����ڣ������ļ�Ŀ¼
            if (!dir.exists()) {
                dir.mkdir();
                logger.info("�����ļ�Ŀ¼�ɹ���" + realPath);
            }
            File file = new File(realPath, picName);
            multipartFile.transferTo(file);
            logger.info("���ͼƬ�ɹ���");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
