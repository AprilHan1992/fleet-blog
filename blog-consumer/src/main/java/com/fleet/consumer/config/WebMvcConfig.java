package com.fleet.consumer.config;

import com.fleet.consumer.config.interceptor.TokenInterceptor;
import com.fleet.consumer.config.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author April Han
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns());
    }

    @Bean
    public TokenInterceptor tokenInterceptor() {
        List<String> patternList = new ArrayList<>();
        patternList.add("/token/refresh");
        return new TokenInterceptor(patternList);
    }

    @Bean
    UserInterceptor userInterceptor() {
        return new UserInterceptor();
    }

    public List<String> excludePathPatterns() {
        List<String> patterns = new ArrayList<>();
        patterns.add("/login");
        patterns.add("/blog/**");
        return patterns;
    }
}
