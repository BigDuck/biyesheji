/*
 * Copyright (c) 2016 - 2 - 29  5 : 18 :39
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.util.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityTools {
    /**
     * 获取用户名字
     *
     * @return 用户的名字
     */
    public static String getUserName() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    /**
     * 获取用户密码
     * @return 用户密码
     */
    public static String getUserPassword() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getPassword();
    }

    /**
     * 获取用户权限
     * @return 权限数组
     */
    public static Object[] getUserAuthorities(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getAuthorities().toArray();
    }
}