package com.hsmy.app.utils;


import com.alibaba.fastjson.JSON;
import com.hsmy.app.bean.ApiResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.*;

public class EbaseYunMessageUtil {

    private static final Log logger = LogFactory.getLog(EbaseYunMessageUtil.class);

    /**
     * 产品密钥ID，产品标识
     */
    private final static String SECRETID = "923d7646e11f4f945a608f1fbe8fb980";
    /**
     * 产品私有密钥，服务端生成签名信息使用，请严格保管，避免泄露
     */
    private final static String SECRETKEY = "cd2044fad9da8597087c54a3b46f187b";
    /**
     * 业务ID，易盾根据产品业务特点分配
     */
    private final static String BUSINESSID = "e9bcd482f96e4de4bb9c3ecf43f74366";
    /**
     * 本机认证服务身份证实人认证在线检测接口地址
     */
    private final static String API_URL = "https://sms.dun.163yun.com/v2/sendsms";

    /**
     * 实例化HttpClient，发送http请求使用，可根据需要自行调参
     */

    public static ApiResponse sendMsg(String phoneNo) throws Exception {

        java.util.Map<String, Object> params = new HashMap<String, Object>();
        // 1.设置公共参数
        params.put("secretId", SECRETID);
        params.put("businessId", BUSINESSID);
        params.put("version", "v2");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        //32随机字符串
        //params.put("nonce", getRandomStr(32));
        params.put("nonce", "dh2u81hdah129zjk2hlla118snebd2q1");

        String curTime = String.valueOf((new Date().getTime() / 1000L));
        String checkSum = CheckSumBuilder.getCheckSum(SECRETID, "dh2u81hdah129zjk2hlla118snebd2q1", curTime);
        String checkCode = checkSum.substring(0, 6);
        // 2.设置私有参数d
        params.put("mobile", phoneNo);
        params.put("params", "code=" + checkCode);
        params.put("templateId", "10150");
        //params.put("internationalCode", internationalCode);
        //需要上行的时候,这里需要设置为true
        params.put("needUp", "true");

        // 3.生成签名信息
        String signature = SignatureUtils.genSignature(SECRETKEY, params);
        params.put("signature", signature);
        // 4.发送HTTP请求，这里使用的是HttpClient工具包，产品可自行选择自己熟悉的工具包发送请求
        String response = "{\"code\":200,\"msg\":\"ok\",\"data\":{\"result\":200,\"requestId\":\"3b99008dff394722b87915927bfbcd69\"}}"; //HttpClient4Utils.doPost(API_URL, params);
        logger.info("返回报文： " + response);
        //5.解析报文返回
        ApiResponse apiResponse = JSON.parseObject(response, ApiResponse.class);
        apiResponse.setCheckNum(checkCode);
        return apiResponse;

    }

    /**
     * 生成随机数
     *
     * @param num 位数
     * @return
     */
    public static String createRandomNum(int num) {
        String randomNumStr = "";
        for (int i = 0; i < num; i++) {
            int randomNum = (int) (Math.random() * 10);
            randomNumStr += randomNum;
        }
        return randomNumStr;
    }


//
//    //发送验证码的请求路径URL
//    private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";
//    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
//    private static final String APP_KEY="94adf221c0ef480daded3e2cea012e64";
//    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
//    private static final String APP_SECRET="f25d046919114002872ca4630e69d848";
//    //随机数
//    private static final String NONCE="123456";
//    //短信模板ID
//    private static final String TEMPLATEID="9534479";
//    //手机号
////    private static final String MOBILE="接收者，当然这里注释了。";
//    //验证码长度，范围4～10，默认为4
//    private static final String CODELEN="6";
//
//    public static String sendMsg(String phone) throws IOException {
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpPost post = new HttpPost(SERVER_URL);
//
////      CheckSum的计算
//        String curTime=String.valueOf((new Date().getTime()/1000L));
//        String checkSum= CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);
//
//        //设置请求的header
//        post.addHeader("AppKey",APP_KEY);
//        post.addHeader("Nonce",NONCE);
//        post.addHeader("CurTime",curTime);
//        post.addHeader("CheckSum",checkSum);
//        post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
//
//        //设置请求参数
//        List<NameValuePair> nameValuePairs =new ArrayList<>();
//        nameValuePairs.add(new BasicNameValuePair("mobile",phone));
//        nameValuePairs.add(new BasicNameValuePair("templateid", TEMPLATEID));
//        nameValuePairs.add(new BasicNameValuePair("codeLen", CODELEN));
//
//        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));
//
//        //https://dev.yunxin.163.com/docs/product/%E7%9F%AD%E4%BF%A1/%E7%9F%AD%E4%BF%A1%E7%8A%B6%E6%80%81%E7%A0%81
//        //执行请求
//        HttpResponse response=httpclient.execute(post);
//        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");
//
//        //获取发送状态码
//        String code= JSON.parseObject(responseEntity).getString("code");
//        if (code.equals("200")){
//            logger.info ("发送成功！"  +   JSON.parseObject(responseEntity).getString("obj"));
//            return  JSON.parseObject(responseEntity).getString("obj");
//        }
//        logger.info("发送失败！"  + code);
//        return "";
//    }
}
