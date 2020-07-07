package com.jie.stupiddog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/css/")
                .addResourceLocations("classpath:/js/")
                .addResourceLocations("classpath:/images/")
                .addResourceLocations("classpath:/mybatis/")
                .addResourceLocations("classpath:/swiper/");
    }
}
