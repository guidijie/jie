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

        //获取文件的真实路径
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\";
        //       /images/**是对应resource下工程目录
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+path);

    }
}
