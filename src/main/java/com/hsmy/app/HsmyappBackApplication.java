package com.hsmy.app;

import com.hsmy.app.web.support.WebTokenHandlerInterceptor;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
//@MapperScan(value = "com.hsmy.app.mapper")
public class HsmyappBackApplication extends WebMvcConfigurerAdapter {

    @Bean
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource(poolProperties());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public PoolProperties poolProperties() {
        return new PoolProperties();
    }

    @Bean
    WebTokenHandlerInterceptor webTokenHandlerInterceptor() {
        return new WebTokenHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webTokenHandlerInterceptor()).addPathPatterns("/**");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HsmyappBackApplication.class, args);
    }

}

