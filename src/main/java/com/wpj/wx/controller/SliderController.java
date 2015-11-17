/*
 * Copyright (c) 2015 - 10 - 17  6 : 8 :49
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wpj.wx.serviceImpl.SliderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/17.
 */
@RestController
@RequestMapping("/sliders")
public class SliderController extends BaseController {
    @Autowired
    SliderServiceImpl sliderService;
    @RequestMapping("/slider/{id}")
    @ResponseBody
    public Object getSlider(@PathVariable("id")int  id,String callbackparam){
        Map<String,Object> map=new HashMap<>();
        map.put("slider",sliderService.findAllMenuMessageById(id));
        return super.toClient(callbackparam,map);
    }
}
