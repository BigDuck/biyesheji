/*
 * Copyright (c) 2016 - 2 - 23  11 : 26 :52
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin.count;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.Authorization;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.common.Config;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.daomain.TbRemote;
import com.wpj.wx.service.RemoteService;
import com.wpj.wx.util.DateUtil;
import com.wpj.wx.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Name：CountController
 * Time：2016/2/23 11:26
 * author：WPJ587
 * description：运维统计控制器
 **/
@Controller
@RequestMapping("/admin")
@ApiIgnore
public class CountController extends BaseController {
    @Autowired
    RemoteService remoteService;
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public Object toCount(ModelMap map){
        // 当未选择时间的时候现实最近7天
        map.addAttribute("MyTemplate", "admin/count/count.vm");
        return Config.INDEX;
    }
    @RequestMapping(value = "/count/getCount",method = RequestMethod.POST)
    @ResponseBody
    @Procedure(description = "访问运维统计")
    public Object getCount(HttpServletRequest request){
        Date startTime=DateUtil.getYesterday(new Date(),true,7);
        Date endTime=new Date();
        String ipAddress=null;
        if(StringUtils.isNoneEmtryAndNull(request.getParameter("startTime"))){
            startTime= DateUtil.str2Date(request.getParameter("startTime").toString());
        }
        if(StringUtils.isNoneEmtryAndNull(request.getParameter("endTime"))){
            endTime=DateUtil.str2Date(request.getParameter("endTime").toString());
        }
        if(StringUtils.isNoneEmtryAndNull(request.getParameter("ipAddress"))){
            ipAddress=request.getParameter("ipAddress").toString();
        }
      List<TbRemote> result=remoteService.findRemotebList(startTime,endTime,ipAddress);
        return remoteService.toEchartData(result, startTime,endTime,ipAddress);
    }
}
