/*
 * Copyright (c) 2015 - 10 - 13  10 : 34 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * The type Cache manager check.
 */
@Component
public class CacheManagerCheck {
private Logger logger= LoggerFactory.getLogger(CacheManagerCheck.class);
	/**
	 * Cache manager cache manager.
	 *
	 * @return the cache manager
	 */
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	/**
	 * Eh cache cache manager eh cache manager factory bean.
	 *
	 * @return the eh cache manager factory bean
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		logger.info("ehcache缓存加载完成");
		return cmfb;
	}

}
