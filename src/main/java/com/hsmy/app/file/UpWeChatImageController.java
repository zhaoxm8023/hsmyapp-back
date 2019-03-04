package com.hsmy.app.file;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
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
        SaveWechatImage(multipartFile, realPath);
        return "1";
    }

    @RequestMapping(value = "/hsmy/infopub/batchUploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
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
                    SaveWechatImage(multipartFile, realPath);
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


    private void SaveWechatImage(MultipartFile multipartFile, String realPath) {
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


