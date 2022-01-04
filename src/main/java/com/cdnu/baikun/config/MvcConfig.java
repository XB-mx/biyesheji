package com.cdnu.baikun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 进行静态资源映射
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${user.filepath}")
    private String filepath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:" + filepath);
    }
}
