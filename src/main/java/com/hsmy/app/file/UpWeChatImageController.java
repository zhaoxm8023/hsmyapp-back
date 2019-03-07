package com.hsmy.app.file;

import com.hsmy.app.BusinessException;
import com.hsmy.app.bean.HsmyInfoPub;
import com.hsmy.app.constant.ConstantErrMsg;
import com.hsmy.app.mapper.HsmyInfoPubMapper;
import com.hsmy.app.utils.CommonToolsUtils;
import com.hsmy.app.utils.WechatUtils;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.Date;
import java.util.List;

@RestController
public class UpWeChatImageController {
    private static final Log logger = LogFactory.getLog(UpWeChatImageController.class);

    @Autowired
    HsmyInfoPubMapper hsmyInfoPubMapper;

    @Autowired
    HsmyInfoPub hsmyInfoPub;

    @Value("${wechat.infopub.filepath}")
    String infopubFilesPath;

    @Value("${wechat.infopub.filesplitchar}")
    String splitchar;

    @RequestMapping(value = "/hsmy/batchUploadImage", method =  RequestMethod.POST )
    public Result<HsmyInfoPub>  handleFileUpload(HttpServletRequest request, HttpServletResponse response) {
        try {
            MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;
            String openid = request.getHeader("openid");
            List<MultipartFile> multipartFiles = mulRequest.getFiles("infopubfiles");
            String infoSerno = mulRequest.getParameter("infoSerno");
            String picsDesc = infopubFilesPath + "\\Default.png";  //加一张默认一张图片
            if (CommonToolsUtils.isNotNull(multipartFiles) && multipartFiles.size() != 0) {
                picsDesc = "";
                MultipartFile multipartFile = null;
                BufferedOutputStream stream = null;
                for (int i = 0; i < multipartFiles.size(); ++i) {
                    multipartFile = multipartFiles.get(i);
                    if (!multipartFile.isEmpty()) {
                        try {
                            //存储图片
                            picsDesc += WechatUtils.SaveWechatImage(multipartFile, infopubFilesPath + "\\" + openid) +  splitchar;;
                        } catch (Exception e) {
                            logger.debug(e);
                            stream = null;
                            return DefaultResult.newFailResult( ConstantErrMsg.INFOPUBMSG + ConstantErrMsg.UPDATEFAIL + ConstantErrMsg.TRYCATCHEXCEPTION);
                        }
                    }
                }

                //更新信息
                hsmyInfoPub.setInfoSerno(infoSerno);
                hsmyInfoPub.setPicsDesc(picsDesc);
               // hsmyInfoPub.setLastDate(new Date());
                int count = hsmyInfoPubMapper.updatePicDescByInfoSerno(infoSerno);
                if (CommonToolsUtils.isNotNull(count) && count > 0) {
                    return DefaultResult.newResult(hsmyInfoPub);
                } else {
                    return DefaultResult.newFailResult( ConstantErrMsg.INFOPUBMSG + ConstantErrMsg.UPDATEFAIL  );
                }
            } else {
                return DefaultResult.newFailResult( ConstantErrMsg.INFOPUBMSG + ConstantErrMsg.UPDATEFAIL  );
            }
        } catch (Exception e) {
            return DefaultResult.newFailResult( ConstantErrMsg.INFOPUBMSG + ConstantErrMsg.UPDATEFAIL + ConstantErrMsg.TRYCATCHEXCEPTION);
        }
    }
}


