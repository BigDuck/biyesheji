/*
 * Copyright (c) 2015 - 10 - 13  10 : 46 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class App  extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
        return application.sources(App.class);
    }

}
