/*
 * Copyright (c) 2015 - 10 - 14  11 : 19 :44
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.daomain.TbMenu;
import com.wpj.wx.serviceImpl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/14.
 */
@RestController
@RequestMapping("/menus")
public class MenuController extends BaseController {
    @Autowired
    MenuServiceImpl menuService;

    @RequestMapping(value = "/menu/{id}")
    public Object getMenuById(@PathVariable("id")int id,String callbackparam){
        Map<String,Object> menu=new HashMap<>();
        System.out.println(menu);
        TbMenu tbMenu= menuService.findAllMenuMessageById(id);
        Map<String,Object> map=new HashMap<>();
        map.put("menu",tbMenu);
        return super.toClient(callbackparam,map);
    }

}
