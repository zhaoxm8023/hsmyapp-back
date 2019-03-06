package com.hsmy.app.file;

import com.hsmy.app.bean.HsmyInfoPub;
import com.hsmy.app.utils.WechatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UpWeChatImageController {
    private static final Log logger = LogFactory.getLog(UpWeChatImageController.class);

    @RequestMapping(value = "/hsmy/infopub/uploadImage", method = { RequestMethod.POST,RequestMethod.GET}, consumes ="multipart/form-data")
    public String uploadPicture(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        //对应前端的upload的name参数"file"
        MultipartFile multipartFile = req.getFile("file");

        //realPath填写电脑文件夹路径
        String realPath = "D:\\Pictures\\WeChatPic";
        WechatUtils.SaveWechatImage(multipartFile, realPath);
        return "1";
    }

    @RequestMapping(value = "/hsmy/infopub/batchUploadImage", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request, @RequestBody HsmyInfoPub infoPub) {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> multipartFiles = ((MultipartHttpServletRequest) request).getFiles("file");
        String name=params.getParameter("name");
        System.out.println("name:"+name);
        String id=params.getParameter("id");
        System.out.println("id:"+id);
        MultipartFile multipartFile = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < multipartFiles.size(); ++i) {
            multipartFile = multipartFiles.get(i);
            if (!multipartFile.isEmpty()) {
                try {
                    //realPath填写电脑文件夹路径
                    String realPath = "D:\\Pictures\\WeChatPic";
                    //格式化时间戳
                    WechatUtils.SaveWechatImage(multipartFile, realPath);
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "  + e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }
        return "upload successful";
    }




}


