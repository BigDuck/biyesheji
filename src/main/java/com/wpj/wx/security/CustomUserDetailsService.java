/*
 * Copyright (c) 2016 - 2 - 29  4 : 36 :33
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.security;

import com.wpj.wx.damain.SUser;
import com.wpj.wx.damain.SecurityUser;
import com.wpj.wx.service.SUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Name：CustomUserDetailsService
 * Time：2016/2/29 16:36
 * author：WPJ587
 * description：用户鉴定
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {
   private Logger logger= LoggerFactory.getLogger(CustomUserDetailsService.class);
    @Autowired
  private SUserService sUserService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
     // 根据email去数据库获取数据，使用email进行用户登录
        SUser user=sUserService.loginAndAuth(new SUser(s));
        if(user==null){
            logger.error("用户:{}尝试登录失败",s);
            throw new UsernameNotFoundException("用户："+s+"不存在");
        }
        return new SecurityUser(user);
    }
}
