/*
 * Copyright (c) 2016 - 2 - 29  4 : 58 :58
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.security;

import com.wpj.wx.damain.SUser;
import com.wpj.wx.service.SUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Name：LoginSuccessHandler
 * Time：2016/2/29 16:58
 * author：WPJ587
 * description：登陆成功处理类
 **/

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private SUserService sUserService;
    private Logger logger= LoggerFactory.getLogger(LoginSuccessHandler.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        SUser userDetails = (SUser)authentication.getPrincipal();
        userDetails.setDob(new Date());
        sUserService.updateNotNull(userDetails);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
