/*
 * Copyright (c) 2016 - 1 - 31  10 : 59 :58
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.common;

import com.mangofactory.swagger.annotations.ApiIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Name：uploadPhotoController
 * Time：2016/1/31 22:59
 * author：WPJ587
 * description：图片上传控制器
 **/
@Controller
@RequestMapping("/admin")
@ApiIgnore
public class uploadPhotoController  extends BaseController{
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){
        MyLogeer.info("访问上传页面");
        return "admin/module/slider/photoUpload";
    }
}
