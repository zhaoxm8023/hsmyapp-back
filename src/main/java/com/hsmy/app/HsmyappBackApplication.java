package com.hsmy.app;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@EnableApolloConfig
//@MapperScan(value = "com.hsmy.app.mapper")
public class HsmyappBackApplication extends  SpringBootServletInitializer  {

    @Bean
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource(poolProperties());
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource" )
    public PoolProperties poolProperties()  {
        return new PoolProperties();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HsmyappBackApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HsmyappBackApplication.class);
    }




}

