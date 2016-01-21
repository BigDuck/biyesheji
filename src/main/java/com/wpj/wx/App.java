/*
 * Copyright (c) 2015 - 10 - 13  10 : 46 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx;

import com.wpj.wx.util.FileUploadConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class App  extends WebMvcConfigurerAdapter
{
    @Autowired
    FileUploadConfiguration fileUploaderConfiguration;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String location = "file:" + fileUploaderConfiguration.getPathToUploadFolder();
        registry.addResourceHandler("/images/**").addResourceLocations(location);
    }

    @Bean
    @ConfigurationProperties("fileUpload")
    public FileUploadConfiguration uploaderConfiguration() {
        return new FileUploadConfiguration();
    }
}
