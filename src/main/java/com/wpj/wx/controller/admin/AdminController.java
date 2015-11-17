/*
 * Copyright (c) 2015 - 10 - 23  2 : 24 :46
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpj.wx.common.Page;
import com.wpj.wx.controller.BaseController;
import com.wpj.wx.daomain.TbHeader;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.serviceImpl.HeaderServiceImpl;
import com.wpj.wx.serviceImpl.ListMainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by WPJ587 on 2015/10/23.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    HeaderServiceImpl headerService;




    @RequestMapping(value = "/main/header",method = RequestMethod.GET)
    public String test (ModelMap map){
         TbHeader tbHeader= headerService.selectByKey(1);
        map.addAttribute("MyTemplate","admin/module/headerContent.vm");
        map.addAttribute("header",tbHeader);
        return "admin/index";
    }
    @RequestMapping(value = "/main/header",method = RequestMethod.POST)
    public String updateHeader (ModelMap map,@ModelAttribute("header")@Valid TbHeader header){
        MyLogeer.info("前台："+header.toString());
        map.addAttribute("MyTemplate","admin/module/headerContent.vm");
        return "admin/index";
    }


}
