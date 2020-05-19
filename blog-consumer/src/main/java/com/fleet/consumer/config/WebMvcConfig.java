package com.fleet.consumer.config;

import com.fleet.consumer.config.interceptor.TokenInterceptor;
import com.fleet.consumer.config.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/**/v2/api-docs", "/swagger-ui.html/**", "/csrf", "/error", "/") //放行swagger接口文档地址
                .excludePathPatterns(excludePathPatterns());
    }

    @Bean
    TokenInterceptor tokenInterceptor() {
        TokenInterceptor tokenInterceptor = new TokenInterceptor();
        tokenInterceptor.setRefreshTokenPathPatterns("/token/refresh");
        return tokenInterceptor;
    }

    @Bean
    UserInterceptor userInterceptor() {
        return new UserInterceptor();
    }

    public List<String> excludePathPatterns() {
        List<String> patterns = new ArrayList<>();
        patterns.add("/login");
        patterns.add("/open/**");
        return patterns;
    }
}
