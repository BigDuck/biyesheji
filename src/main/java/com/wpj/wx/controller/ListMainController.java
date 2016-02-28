/*
 * Copyright (c) 2016 - 2 - 28  3 : 46 :16
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wordnik.swagger.annotations.Api;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.service.ListMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Name：ListMainController
 * Time：2016/2/28 15:45
 * author：WPJ587
 * description：文章是实体类控制器
 **/
@RestController
@Api(basePath = "/listmain",description = "获取文章详细内容",value = "TbListmain")
@RequestMapping(value = "/listmain",method = RequestMethod.GET)
public class ListMainController extends BaseController {
    @Autowired
    ListMainService listMainService;

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Object getListMainById(@RequestParam(value = "id",required = true)Integer id, String callbackparam){

        return super.toClient(callbackparam,listMainService.getListMainById(id));
    }
}
