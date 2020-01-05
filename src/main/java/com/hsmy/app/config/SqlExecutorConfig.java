package com.hsmy.app.config;


import com.hsmy.app.interceptor.MybatisInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class SqlExecutorConfig {
    @Bean
    public String myInterceptor(SqlSessionFactory sqlSessionFactory) {
//        MybatisInterceptor executorInterceptor = new MybatisInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("prop1","value1");
//        executorInterceptor.setProperties(properties);
//        sqlSessionFactory.getConfiguration().addInterceptor(executorInterceptor);
//        //sqlSessionFactory.getConfiguration().addInterceptor(new ParamInterceptor());
//        //sqlSessionFactory.getConfiguration().addInterceptor(new ResultInterceptor());
        return "interceptor";
    }
}
