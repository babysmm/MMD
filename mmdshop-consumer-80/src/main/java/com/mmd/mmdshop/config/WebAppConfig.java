package com.mmd.mmdshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 
 * @ClassName WebAppConfig.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**")
        												 .excludePathPatterns("/consumer/adminUserLogin","/consumer/staffUserLogin","/error");
    }
}
