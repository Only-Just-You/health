package com.health;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.health.mapper")
public class GooglehealthApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(GooglehealthApplication.class, args);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")    //允许任何头
                .allowedOrigins("*")    //允许任何域名
                .allowedMethods("*")   //允许任何方法
                .maxAge(3600);         // 有效期
    }


}
