package com.cdnu.baikun.config;

import com.cdnu.baikun.interceptor.AdminInterceptor;
import com.cdnu.baikun.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册admin拦截器和login拦截器
 *
 * @author 白坤
 * @date 2021/7/11
 */
@Configuration
public class AdminInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AdminInterceptor adminInterceptor;
    @Autowired
    LoginInterceptor loginInterceptor;

    /**
     * 实现注册，拦截地址定义admin
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录验证
        registry.addInterceptor(loginInterceptor).addPathPatterns("/account/**");

        //用户权限验证
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin");
    }

}
