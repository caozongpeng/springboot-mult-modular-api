package com.tz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * @author KyrieCao
 * @date 2020/2/17 22:28
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // Swagger配置拦截器
        registry.addInterceptor(swaggerInterceptor()).addPathPatterns("/swagger-ui.html", "/doc.html");

        // 接口幂等性拦截器
        registry.addInterceptor(apiIdempotentInterceptor());

        // 接口防刷限流拦截器
        registry.addInterceptor(accessLimitInterceptor());

    }

    @Bean
    public AccessLimitInterceptor accessLimitInterceptor() {
        return new AccessLimitInterceptor();
    }

    @Bean
    public ApiIdempotentInterceptor apiIdempotentInterceptor() {
        return new ApiIdempotentInterceptor();
    }

    @Bean
    public SwaggerInterceptor swaggerInterceptor() {
        return new SwaggerInterceptor();
    }

}
