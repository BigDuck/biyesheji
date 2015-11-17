/*
 * Copyright (c) 2015 - 10 - 13  10 : 34 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.db;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * druid的拦截器配置
 * 感谢colddew帮助
 * https://github.com/colddew/micro-service
 */
@Configuration
public class InterceptorConfig {
	
	@Bean
	public DruidStatInterceptor druidStatInterceptor() {
		return new DruidStatInterceptor();
	}
	
	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
		
		BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
		creator.setProxyTargetClass(true);
		creator.setBeanNames("personController");
		creator.setInterceptorNames("druidStatInterceptor");
		
		System.out.println("load druid stat interceptor...");
		
		return creator;
	}
}
