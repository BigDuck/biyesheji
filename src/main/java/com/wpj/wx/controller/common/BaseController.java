/*
 * Copyright (c) 2015 - 10 - 17  8 : 26 :33
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.common;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wpj.wx.daomain.TbRemote;
import com.wpj.wx.service.RemoteService;
import com.wpj.wx.util.InternetProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by WPJ587 on 2015/10/17.
 */
@Controller

public class BaseController {
    protected Logger MyLogeer = LoggerFactory.getLogger(this.getClass().getName());
    protected String MYTAG = this.getClass().getName();
    @Autowired
    HttpServletRequest request;
    TbRemote tbRemote = null;
    @Autowired
    RemoteService remoteService;

    public Object toClient(String callbackParam, Object object) {
        // 调用统计生成的
        String ip = InternetProtocol.getRemoteAddr(request);
        tbRemote = new TbRemote();
        tbRemote.setRemoteDate(new Date());
        tbRemote.setRemoteIp(ip);
        tbRemote.setRemoteCount(1L);
        remoteService.save(tbRemote);
        MyLogeer.info("访问记录:{}",tbRemote.toString());

        if (callbackParam == null) {
            return object;
        } else {
            return new JSONPObject(callbackParam, object);
        }
    }

}
