package com.tz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Swagger拦截器配置
 * @author KyrieCao
 * @date 2020/2/4 20:12
 */
@Configuration
public class SwaggerInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private SwaggerInterceptor swaggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(swaggerInterceptor).addPathPatterns("/swagger-ui.html", "/doc.html");
    }
}
