/*
 * Copyright (c) 2015 - 10 - 17  6 : 8 :49
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
import com.wpj.wx.damain.TbSlider;
import com.wpj.wx.serviceimpl.SliderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/17.
 */
@RestController
@RequestMapping("/sliders")
@Api(basePath = "/sliders", value = "TbSlider", description = "轮播")
public class SliderController extends BaseController {
    @Autowired
    private SliderServiceImpl sliderService;

    /**
     * Gets slider.
     *
     * @param id            the id
     * @param callbackparam the callbackparam
     * @return the slider
     */
    @RequestMapping("/slider/{id}")
    @ResponseBody
    @ApiOperation(value = "获取轮播信息", httpMethod = "GET", notes = "根据轮播id获取轮播的信息", response = BaseResult.class)
    @Procedure(description = "获取轮播信息")
    public Object getSlider(@ApiParam(name = "id", required = true, value = "轮播Id")
                            @PathVariable("id") int id, String callbackparam) {
        Map<String, Object> map = new HashMap<>();
        map.put("slider", sliderService.findAllMenuMessageById(id));
        return super.toClient(callbackparam, map);
    }

    /**
     * Add header object.
     *
     * @param tbSlider      the tb slider
     * @param callbackparam the callbackparam
     * @return the object
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "增加轮播信息", httpMethod = "POST", notes = "增加轮播信息", response = BaseResult.class)
    public Object addHeader(@ApiParam(name = "id", required = true, value = "轮播Id")
                            @RequestBody TbSlider tbSlider, String callbackparam) {
        MyLogeer.info("传来的实体" + tbSlider);
        return super.toClient(callbackparam, null);
    }

}
