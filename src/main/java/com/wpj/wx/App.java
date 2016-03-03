/*
 * Copyright (c) 2015 - 10 - 13  10 : 46 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */
package com.wpj.wx;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wpj.wx.util.FileUploadConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
@EnableScheduling //定时任务
@EnableSwagger
public class App  extends WebMvcConfigurerAdapter
{
    @Autowired
    FileUploadConfiguration fileUploaderConfiguration;
    @Resource
    private SpringSwaggerConfig springSwaggerConfig;
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
    @Bean  // Don't forget the @Bean annotation
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns("/(?!error).*")
                ;
    }
    private ApiInfo apiInfo() {
//  ApiInfo(String title, String description, String termsOfServiceUrl, String contact, String license, String licenseUrl)

        ApiInfo apiInfo = new ApiInfo("Rest API.作者吴培基",
                "前端API接口文档",
                "https://github.com/BigDuck",
                "757671834@qq.com",
                "Apache LICENSE-2.0",
                "http://www.apache.org/licenses/LICENSE-2.0"
        );
        return apiInfo;
    }

    /**
     * 为了启用自己定义的错误处理
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return registration;
    }


}
