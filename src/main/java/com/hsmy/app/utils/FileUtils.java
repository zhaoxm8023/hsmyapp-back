package com.hsmy.app.utils;
import java.io.File;
import java.util.ArrayList;

/**
 * @Author: zhaoxm
 * @Date: 2019/7/28 16:56
 * @Version 1.0
 * @Desc:
 */
public class FileUtils {
    public static ArrayList<String> getFileListame(String strPath,String fileName) {
        File dir = new File(strPath);
        String[] files = dir.list(); // 该微信客户目录下文件全部放入数组
        ArrayList<String> templFileName = new ArrayList<>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if(files[i].indexOf(fileName)!=-1){
                    templFileName.add(files[i]);
                }
            }
            return templFileName;
        }
        else{
            return null;
        }
    }
}
