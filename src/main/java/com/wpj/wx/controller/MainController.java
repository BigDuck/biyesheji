/*
 * Copyright (c) 2015 - 10 - 22  7 : 22 :55
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wordnik.swagger.annotations.Api;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/22.
 */
@RestController
@RequestMapping("/main")
@Api(basePath = "/main", value = "All", description = "一次性获取所有的数据")
public class MainController extends BaseController {
    @Autowired
    HeaderService headerService;
    @Autowired
    MenuService menuService;
    @Autowired
    ListMainService listMainService;
    @Autowired
    SliderService sliderService;
    @Autowired
    ListService listService;
    @RequestMapping(value = "/all",
            method = RequestMethod.GET)
    @ResponseBody
    @Procedure(description = "获取整体数据")
    public Object getMainUIMessage(String callbackparam) {
//        for(Map.Entry<String,Object> entry:map.entrySet()){
//            MyLogeer.info(MYTAG,"key="+entry.getKey()+"\n "+"value="+entry.getValue());
//        }
        // 获取header
        List<Object> result=new ArrayList<>();
        Map<String,Object> param=new HashMap<>();
        Map<String,Object> header=headerService.findDataMapById(1);
        param.put("header",(header.get("header")));
        param.put("menu",menuService.findAllMenuMessageById(1));
        param.put("list",listService.findALlListById(1));
        param.put("slider",sliderService.findAllMenuMessageById(1));
        result.add(param);
        System.out.println("\n\n\n\n\n\n\n\n"+result.toString());
        return super.toClient(callbackparam,result);
    }
}
