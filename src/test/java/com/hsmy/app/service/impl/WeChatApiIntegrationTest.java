package com.hsmy.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.hsmy.app.utils.JsonUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * 集成测试验证，需要提供 form_id 才可以进行测试.
 *
 * @author devzzm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatApiIntegrationTest {

    private static final Log logger = LogFactory.getLog(WeChatApiIntegrationTest.class);

    @Value("${wechat.app-id}")
    private String appId;

    @Value("${wechat.app-secret}")
    private String appSecret;

    @Value("${wechat.notify.template-id}")
    private String templateId;

    private String accessToken;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void init() {
        String result = restTemplate.getForObject(
                "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appId}&secret={appSecret}",
                String.class, appId, appSecret);
        accessToken = (String) JsonUtils.decode(result).get("access_token");
        Assert.assertNotNull(accessToken);
    }

    @Test
    public void testSendMessage() {
        Map<String, Object> request = new HashMap<>();
        // TODO 目标用户的 openId 需要按实际指定
        request.put("touser", "oFb4O0XMZrijTGa_5kli4E6shEV0");
        request.put("template_id", templateId);
        // TODO 后续验证需要提供 from_id才可以进行
        request.put("form_id", "1504144250621");
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> keyword1 = new HashMap<>();
        keyword1.put("value", "11111");
        data.put("keyword1", keyword1);

        Map<String, Object> keyword2 = new HashMap<>();
        keyword2.put("value", "22222");
        data.put("keyword2", keyword2);

        Map<String, Object> keyword3 = new HashMap<>();
        keyword3.put("value", "33333");
        data.put("keyword3", keyword3);

        Map<String, Object> keyword4 = new HashMap<>();
        keyword4.put("value", "44444");
        data.put("keyword4", keyword4);

        Map<String, Object> keyword5 = new HashMap<>();
        keyword5.put("value", "5555");
        data.put("keyword5", keyword5);
        request.put("data", data);
        String result = restTemplate.postForObject(
                "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token={ACCESS_TOKEN}", request,
                String.class, accessToken);
        logger.info(result);
    }


    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("REQUEST_MESSAGE", "2222");
        new RestTemplate().postForObject(
                "http://localhost:8080/MOBX-ANTD-ADMIN/loginProcess.json?REQUEST_MESSAGE=2222", data, String.class);
    }
}








