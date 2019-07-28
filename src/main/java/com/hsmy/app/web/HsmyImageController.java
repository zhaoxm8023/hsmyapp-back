package com.hsmy.app.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: zhaoxm
 * @Date: 2019/7/28 18:34
 * @Version 1.0
 * @Desc:
 */
@RestController
@RequestMapping(value = "/image")
public class HsmyImageController {
    @Value("${wechat.infopub.filepath}")
    String infopubFilesPath;

    //查询全部信息 注意翻页查询！
    @ApiOperation(value = "查询发布信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]>  getImage(@RequestParam(value="imageName" ,required =true ) String imageName,@RequestParam(value="openId" ,required =true ) String openId) {
        try {
            byte[] imageContent ;
            String path = infopubFilesPath + File.separator + openId + File.separator  + imageName;
            imageContent = fileToByte(new File(path));
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] fileToByte(File img) throws Exception {
        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, "png", baos);
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baos.close();
        }
        return bytes;
    }
}
