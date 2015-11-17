/*
 * Copyright (c) 2015 - 10 - 18  6 : 21 :56
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wpj.wx.serviceImpl.ListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/18.
 */
@RestController
@RequestMapping("/lists")
public class ListController extends BaseController {
    @Autowired
    ListServiceImpl listService;
    @RequestMapping("/list/{id}")
    public Object getAll(@PathVariable("id")int  id,String callbackparam){
        Map<String,Object> map=new HashMap<>();
        map.put("list1",listService.findALlListById(id));
        return super.toClient(callbackparam,map);
    }


}
