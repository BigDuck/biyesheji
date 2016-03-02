/*
 * Copyright (c) 2015 - 10 - 18  6 : 21 :56
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.damain.BaseResult;
import com.wpj.wx.serviceimpl.ListServiceImpl;
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
@Api(basePath = "/lists", value = "TbList", description = "列表相关")
public class ListController extends BaseController {
    @Autowired
    ListServiceImpl listService;
    @RequestMapping("/list/{id}")
    @ApiOperation(value = "获取列表信息", httpMethod = "GET", notes = "根据列表id获取列表的信息",response = BaseResult.class)
    @Procedure(description = "访问获列表取信息")
    public Object getAll(@ApiParam(name = "id",required = true,value = "列表Id")@PathVariable("id")int  id, String callbackparam){
        Map<String,Object> map=new HashMap<>();
        map.put("list",listService.selectByKey(id));
        return super.toClient(callbackparam,map);
    }

}
