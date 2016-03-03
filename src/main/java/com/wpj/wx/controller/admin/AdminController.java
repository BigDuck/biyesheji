/*
 * Copyright (c) 2015 - 10 - 23  2 : 24 :46
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.daomain.TbHeader;
import com.wpj.wx.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by WPJ587 on 2015/10/23.
 */
@Controller
@RequestMapping("/admin")
@ApiIgnore
public class AdminController extends BaseController {
    @Autowired
    HeaderService headerService;
    @RequestMapping(value = {"/main/header","/main"},method = RequestMethod.GET)
    @Procedure(description = "访问网站header操作")
    public String test (ModelMap map){
         TbHeader tbHeader= headerService.selectByKey(1);
        map.addAttribute("MyTemplate","admin/module/headerContent.vm");
        map.addAttribute("header",tbHeader);
        return "admin/index";
    }
    @RequestMapping(value = "/main/header",method = RequestMethod.POST)
    public String updateHeader (ModelMap map,@ModelAttribute("header") TbHeader header){
        MyLogeer.info("前台："+header.toString());
        map.addAttribute("MyTemplate","admin/module/headerContent.vm");
        return "admin/index";
    }



}
