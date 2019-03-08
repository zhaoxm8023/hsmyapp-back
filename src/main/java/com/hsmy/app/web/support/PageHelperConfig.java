package com.hsmy.app.web.support;
import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;
/**
 * @Author: zhaoxm
 * @Date: 2019/3/8 10:47
 * @Version 1.0
 * @Desc:
 */

@Configuration//将该类加到spring容器里
public class PageHelperConfig {
    @Bean//加上该注解spring容器自动配置
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}

