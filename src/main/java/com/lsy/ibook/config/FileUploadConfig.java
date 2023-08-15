package com.lsy.ibook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileUploadConfig implements WebMvcConfigurer {
    @Value("${project.file.access-path}")
    private String url;         // 文件访问路径
    @Value("${spring.servlet.multipart.location}")
    private String filePath;    // 文件存储的真实位置

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(url).addResourceLocations("file:"+filePath);
    }
}
