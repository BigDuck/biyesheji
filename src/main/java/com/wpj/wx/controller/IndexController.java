/*
 * Copyright (c) 2016 - 1 - 19  11 : 9 :15
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.mangofactory.swagger.annotations.ApiIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Name：IndexController
 * Time：2016/1/19 23:09
 * author：WPJ587
 * description：首页控制器
 **/
@Controller
@ApiIgnore
public class IndexController {
    @RequestMapping(value = {"","/index"})
    public Object index(){
    return "index";
    }

}
